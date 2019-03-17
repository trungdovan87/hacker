package com.kamereo.account.problem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SegmentTreeTest {
    private Set<String> createSet(String... arr) {
        return new HashSet<>(Arrays.asList(arr));
    }

    private void assertEqualSets(Set<String> expected, Set<String> actual) {
        Assert.assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test
    public void testOperation() {
        int n = 7;
        Set<String>[] init = new Set[7];
        init[0] = createSet("A", "F");
        init[1] = createSet("A", "B");
        init[2] = createSet("A");
        init[3] = createSet("D");
        init[4] = createSet("A", "C");
        init[5] = createSet("A", "C", "E");
        init[6] = createSet("A", "B");

        SegmentTree tree = new SegmentTree(init);
        assertEqualSets(createSet("A", "B", "C", "D", "E", "F"), tree.query(0, 7));
        assertEqualSets(createSet("A", "B", "C", "E"), tree.query(5, 7));
        assertEqualSets(createSet("A", "B"), tree.query(6, 7));

        init[5].add("G");
        tree.modify(5, init[5]);
        assertEqualSets(createSet("A", "B", "C", "E", "G"), tree.query(5, 7));

        init[6].remove("B");
        tree.modify(6, init[6]);
        assertEqualSets(createSet("A", "C", "E", "G"), tree.query(5, 7));
    }
}
