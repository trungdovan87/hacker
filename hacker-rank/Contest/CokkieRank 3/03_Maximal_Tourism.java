/**
 *  link  : https://www.hackerrank.com/contests/rookierank-3/challenges/maximal-tourism
 *  point : 100/100
*/

/**
 * Solution:
 *  - link: https://www.coursera.org/learn/algorithms-part1/lecture/fjxHC/dynamic-connectivity
 *  - read: Quick Find, Quick Union, Quick Union Improvements (use this)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    static class QuickUnionUF {
        private int[] id;
        private int[] size;

        public QuickUnionUF(int n) {
            id = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }

        private int root(int i) {
            while (i != id[i]) {
                // uncomment to use: Quick union with Path Compression
                // id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (i == j)
                return;
            if (size[i] < size[j]) {
                id[i] = j;
                size[j] += size[i];
            } else {
                id[j] = i;
                size[i] += size[j];
            }
        }

        public int getMaxSize() {
            return Arrays.stream(size).max().getAsInt();
        }
    }

    void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        for(int i=0; i < m; i++){
            int p = in.nextInt() - 1;
            int q = in.nextInt() - 1;
            if (p != q)
                uf.union(p, q);
        }
        System.out.println(uf.getMaxSize());
    }
}