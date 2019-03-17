package com.kamereo.account.problem;

import java.util.HashSet;
import java.util.Set;

public class SegmentTree {
    private int n;
    private Set<String>[] t;

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