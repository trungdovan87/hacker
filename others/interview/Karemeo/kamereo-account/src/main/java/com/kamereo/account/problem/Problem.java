package com.kamereo.account.problem;

import java.util.*;

public class Problem {
    private int size;
    private Set<String>[] permissions;
    private List<Integer>[] edges;

    private int[] pre;
    private int[] end;
    private SegmentTree tree;

    public Problem(int size) {
        init(size);
    }

    public void init(int size) {
        this.size = size;
        permissions = new Set[size];
        edges = new List[size];

        for (int i = 0; i < size; i++) {
            permissions[i] = new HashSet<>();
            edges[i] = new ArrayList<>();
        }
    }

    public void addPermission(int u, String... permissions) {
        this.permissions[u].addAll(Arrays.asList(permissions));
    }

    public void addEdge(int from, int to) {
        edges[from].add(to);
        edges[to].add(from);
    }

    public void process() {
        Graph graph = new Graph(edges);
        graph.calculateOrderTree();
        pre = graph.getPreviousArray();
        end = graph.getEndArray();
        Set<String>[] init = new Set[size];
        for (int i = 0; i < size; i++) {
            init[pre[i]] = permissions[i];
        }
        tree = new SegmentTree(init);
    }

    public List<Set<String>> calculateAll() {
        List<Set<String>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(calculatePermission(i));
        }
        return result;
    }

    public void commandAdd(int user, String permission) {
        permissions[user].add(permission);
        tree.modify(pre[user], permissions[user]);
    }

    public void commandRemove(int user, String permission) {
        permissions[user].remove(permission);
        tree.modify(pre[user], permissions[user]);
    }

    public Set<String> commandQuery(int user) {
        return calculatePermission(user);
    }

    private Set<String> calculatePermission(int user) {
        return tree.query(pre[user], end[user] + 1);
    }
}
