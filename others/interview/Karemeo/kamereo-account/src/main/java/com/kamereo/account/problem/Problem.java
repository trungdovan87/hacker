package com.kamereo.account.problem;

import java.util.*;

public class Problem {
    int n;
    Set<String>[] p;
    List<Integer>[] g;

    int[] pre;
    int[] end;
    private SegmentTree st;

    public Problem(int size) {
        init(size);
    }

    public void init(int size) {
        this.n = size;
        p = new Set[n];
        g = new List[n];

        for (int i = 0; i < n; i++) {
            p[i] = new HashSet<>();
            g[i] = new ArrayList<>();
        }
    }

    public void addPermission(int u, String... permisions) {
        p[u].addAll(Arrays.asList(permisions));
    }

    public void addEdge(int u, int v) {
        g[u].add(v);
        g[v].add(u);
    }

    public void process() {
        Graph graph = new Graph(g);
        graph.calculateOrderTree();
        pre = graph.getPreviousArray();
        end = graph.getEndArray();
        Set<String>[] init = new Set[n];
        for (int i = 0; i < n; i++) {
            init[pre[i]] = p[i];
        }
        st = new SegmentTree(init);
    }

    public Set<String> calculatePermission(int u) {
        return st.query(pre[u], end[u] + 1);
    }

    public List<Set<String>> calculateAll() {
        List<Set<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(calculatePermission(i));
        }
        return result;
    }

    public void commandAdd(int u, String permission) {
        p[u].add(permission);
        st.modify(pre[u], p[u]);
    }

    public void commandRemove(int u, String permission) {
        p[u].remove(permission);
        st.modify(pre[u], p[u]);
    }

    public Set<String> commandQuery(int u) {
        return calculatePermission(u);
    }
}
