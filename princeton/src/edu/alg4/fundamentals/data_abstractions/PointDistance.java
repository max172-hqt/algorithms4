package edu.alg4.fundamentals.data_abstractions;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class PointDistance {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[n];

        for (int i = 0; i < n; i++) {
            int x = StdRandom.uniform(100);
            int y = StdRandom.uniform(100);
            points[i] = new Point2D(x, y);
        }

        double min_distance = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n && j != i; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < min_distance || min_distance == -1) {
                    min_distance = distance;
                }
            }
        }

        StdOut.println("The min distance is : " + min_distance);
    }
}
