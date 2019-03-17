package com.kamereo.account.problem;

import java.util.*;

public class Problem {
    private int size;
    private Set<String>[] permissions;
    private List<Integer>[] edges;

    private int[] preArr;
    private int[] endArr;
    private SegmentTree tree;

    public Problem(int size) {
        init(size);
    }

    private void init(int size) {
        this.size = size;
        permissions = new Set[size];
        edges = new List[size];

        for (int i = 0; i < size; i++) {
            permissions[i] = new HashSet<>();
            edges[i] = new ArrayList<>();
        }
    }

    public void addPermission(int user, String... permissions) {
        this.permissions[user].addAll(Arrays.asList(permissions));
    }

    public void addEdge(int from, int to) {
        edges[from].add(to);
        edges[to].add(from);
    }

    public void process() {
        Graph graph = new Graph(edges);
        graph.calculateOrderTree();
        preArr = graph.getPreviousArray();
        endArr = graph.getEndArray();
        Set<String>[] init = new Set[size];
        for (int i = 0; i < size; i++) {
            init[preArr[i]] = permissions[i];
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
        tree.modify(preArr[user], permissions[user]);
    }

    public void commandRemove(int user, String permission) {
        permissions[user].remove(permission);
        tree.modify(preArr[user], permissions[user]);
    }

    public Set<String> commandQuery(int user) {
        return calculatePermission(user);
    }

    private Set<String> calculatePermission(int user) {
        return tree.query(preArr[user], endArr[user] + 1);
    }
}
