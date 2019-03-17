package com.kamereo.account.problem;

import java.util.HashSet;
import java.util.Set;

public class SegmentTree {
    private int n;
    private Set<String>[] tree;

    public SegmentTree(Set<String>[] x) {
        n = (int) Math.pow(2, Math.ceil(Math.log(x.length) / Math.log(2)));
        tree = new Set[2 * n];
        System.arraycopy(x, 0, tree, n, x.length);
        build();
    }

    private Set<String> combine(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();
        if (a != null) {
            result.addAll(a);
        }
        if (b != null) {
            result.addAll(b);
        }
        return result;
    }

    /***
     * init Segment Tree
     */
    private void build() {
        for (int i = n - 1; i > 0; --i) {
            tree[i] = combine(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    /**
     * update value for position
     * @param position
     * @param value
     */
    public void modify(int position, Set<String> value) {
        position += n;
        tree[position] = value;
        while (position > 1) {
            tree[position / 2] = combine(tree[position], tree[position ^ 1]);
            position /=  2;
        }

    }

    /**
     * Sum on interval [left, right)
     * @param left include left
     * @param right exclude right
     * @return
     */
    public Set<String> query(int left, int right) {
        Set<String> result = new HashSet<>();
        left += n;
        right +=n;
        while (left < right) {
            if (left % 2 == 1) {
                result = combine(result, tree[left]);
                left++;
            }
            if (right % 2 == 1) {
                right--;
                result = combine(result, tree[right]);
            }
            left /= 2;
            right /= 2;
        }

        return result;
    }
}