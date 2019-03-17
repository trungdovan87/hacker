package com.kamereo.account.problem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphTest {
    private List<Integer>[] edges;

    private void addEdge(int u, int v) {
        edges[u].add(v);
        edges[v].add(u);
    }

    @Test
    public void testGraph() {
        int n = 7;
        edges = new List[n];
        for (int i = 0; i < 7; i++) {
            edges[i] = new ArrayList<>();
        }
        addEdge(0, 2);
        addEdge(0, 4);
        addEdge(0, 5);
        addEdge(4, 1);
        addEdge(4, 3);
        addEdge(4, 6);
        Graph graph = new Graph(edges);
        graph.calculateOrderTree();
        Assert.assertArrayEquals(new int[]{0, 3, 1, 4, 2, 6, 5}, graph.getPreviousArray());
        Assert.assertArrayEquals(new int[]{6, 3, 1, 4, 5, 6, 5}, graph.getEndArray());
    }
}
