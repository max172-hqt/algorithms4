package edu.alg4.fundamentals.dynamic_connectivity;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF implements UF {
    private int[] id;
    private int count;

    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
        count = n;
    }

    public void union(int p, int q) {
        if (connected(p, q)) return;
        int newId = id[q];
        int oldId = id[p];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == oldId)
                id[i] = newId;
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // Number of components
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new QuickFindUF(N);
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
