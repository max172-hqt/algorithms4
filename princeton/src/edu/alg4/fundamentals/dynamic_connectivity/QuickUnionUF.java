package edu.alg4.fundamentals.dynamic_connectivity;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF implements UF {
    private int[] id;
    private int count;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        count = n;
    }

    @Override
    public void union(int p, int q) {
        if (connected(p, q)) return;
        int pid = find(p);
        int qid = find(q);
        id[pid] = qid;
        count--;
    }

    @Override
    public int find(int p) {
        // Find the root
        int pid = id[p];
        while (pid != id[pid]) {
            pid = id[pid];
        }
        return id[pid];
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
        UF uf = new QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
        StdOut.println(uf.count());
    }
}
