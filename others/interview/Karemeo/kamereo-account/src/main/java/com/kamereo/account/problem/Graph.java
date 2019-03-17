package com.kamereo.account.problem;

import java.util.List;

public class Graph {
    private int n;
    private int[] pre;
    private int[] end;
    private int[] w;
    private int kw;
    private List<Integer>[] g;

    public Graph(List<Integer>[] g) {
        this.g = g;
        n = g.length;
    }

    public void calculateOrderTree() {
        init();
        dfs(0, -1);
    }

    public int[] getPreviousArray() {
        return copyArray(pre);
    }

    public int[] getEndArray() {
        return copyArray(end);
    }

    private int[] copyArray(int[] arr) {
        int[] result = new int[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);
        return result;
    }

    private void init() {
        pre = new int[n];
        end = new int[n];
        w = new int[n];
        kw = 0;
    }

    private void dfs(int v, int pr) {
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
}
