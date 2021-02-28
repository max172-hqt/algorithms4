package edu.alg4.fundamentals.programming_model;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomSeq {
    private RandomSeq() {}

    public static void main(String[] args) {
        // Commandline arguments
        int n = Integer.parseInt(args[0]);

        if (args.length == 1) {
            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniform();
                StdOut.println(x);
            }
        }
        else if (args.length == 3) {
            double lo = Double.parseDouble(args[1]);
            double hi = Double.parseDouble(args[2]);

            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniform(lo, hi);
                StdOut.println(x);
            }
        }
        else {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
    }
}
