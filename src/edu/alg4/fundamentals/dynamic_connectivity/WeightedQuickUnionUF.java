package edu.alg4.fundamentals.dynamic_connectivity;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF implements UF {
    private int[] id;
//    private int[] size;
    private int[] height;
    private int count;

    public WeightedQuickUnionUF(int n) {
        id = new int[n];
//        size = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
//            size[i] = 1;
            height[i] = 0;
        }
        count = n;
    }

    @Override
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) return;

        if (height[pid] < height[qid]) {
            id[pid] = qid;
//            size[qid] += size[pid];
        }
        else if (height[pid] > height[qid]) {
            id[qid] = pid;
//            size[pid] += size[qid];
        }
        else {
            id[pid] = qid;
            height[qid]++;
        }
        count--;
    }

    @Override
    public int find(int p) {
        // Find the root
        int root = p;
        while (root != id[root]) {
//            id[root] = id[id[root]];
            root = id[root];
        }
//         path compression
        while (p != root) {
            int newp = id[p];
            id[p] = root;
            p = newp;
        }
        return root;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
