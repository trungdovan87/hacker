/***
https://codeforces.com/blog/entry/23170?fbclid=IwAR3Er8UkZPbGRt8-a2W3aWqu0TW49g5qEwtMV2OBX54MAZrT8rOlXE9rBmA
https://codeforces.com/problemset/problem/384/E
https://codeforces.com/blog/entry/10476

https://codeforces.com/contest/620/problem/E
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kamereo {
    private static final String CEO = "CEO";
    private static final String ADD = "ADD";
    private static final String REMOVE = "REMOVE";
    private static final String QUERY = "QUERY";


    public static class SegmentTree {
        int n;
        Set<String>[] t;

        public SegmentTree(Set<String>[] x) {
            n = (int) Math.pow(2, Math.ceil(Math.log(x.length) / Math.log(2)));
            t = new Set[2 * n];
            System.arraycopy(x, 0, t, n, x.length);
            build();
        }

        private Set<String> combine(Set<String> a, Set<String> b) {
            Set<String> result = new HashSet<>();
            if (a != null) result.addAll(a);
            if (b != null) result.addAll(b);
            return result;
        }

        // build the tree
        private void build() {
            for (int i = n - 1; i > 0; --i) {
                t[i] = combine(t[i << 1], t[i << 1 | 1]);
            }
        }

        // set value at position p
        public void modify(int p, Set<String> value) {
            for (t[p += n] = value; p > 1; p >>= 1) {
                t[p >> 1] = combine(t[p], t[p ^ 1]);
            }
        }

        // sum on interval [l, r)
        public Set<String> query(int l, int r) {
            Set<String> res = new HashSet<>();
            for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
                if ((l & 1) == 1) res = combine(res, t[l++]);
                if ((r & 1) == 1) res = combine(res, t[--r]);
            }
            return res;
        }
    }

    int n;
    Set<String>[] p;
    List<Integer>[] g;

    int[] pre;
    int[] end;
    int[] w;
    int kw;

    SegmentTree st;

    void dfs(int v, int pr) {
        pre[v] = kw;
        w[kw++] = v;
        for (int j = 0; j < g[v].size(); j++) {
            int u = g[v].get(j);
            if (u != pr) {
                dfs(u, v);
            }
        }
        end[v] = kw - 1;
    }

    void printPermission(int u) {
        System.out.println(String.join(",", st.query(pre[u], end[u] + 1)));
    }

    int convert(String line) {
        return CEO.equals(line) ? 0 : Integer.parseInt(line.trim());
    }

    void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim()) + 1;

        p = new Set[n];

        g = new List[n];

        for (int i = 0; i < n; i++) {
            p[i] = new HashSet<>();
            g[i] = new ArrayList<>();
            p[i].addAll(Arrays.asList(br.readLine().split(" ")));
        }

        for (int u = 1; u < n; u++) {
            String line = br.readLine();
            int v = CEO.equals(line) ? 0 : Integer.parseInt(line.trim());
            g[u].add(v);
            g[v].add(u);
        }

        pre = new int[n];
        end = new int[n];
        w = new int[n];
        kw = 0;
        dfs(0, -1);

        Set<String>[] init = new Set[n];
        for (int i = 0; i < n; i++) init[pre[i]] = p[i];


        st = new SegmentTree(init);
        for (int i = 0; i < n; i++) printPermission(i);
        while (true) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0].toUpperCase()) {
                case ADD:
                    int u = convert(cmd[1]);
                    p[u].add(cmd[2]);
                    st.modify(pre[u], p[u]);
                    break;
                case REMOVE:
                    u = convert(cmd[1]);
                    p[u].remove(cmd[2]);
                    st.modify(pre[u], p[u]);
                    break;
                case QUERY:
                    u = convert(cmd[1]);
                    printPermission(u);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Kamereo().run();
    }
}
