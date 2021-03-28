package hw3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoint {
    private final Point[] points;

    public BruteCollinearPoint(Point[] points) {
        this.points = points;
        Arrays.sort(points);
    }

    public int numberOfSegments() {
        return segments().length;
    }

    public LineSegment[] segments() {
        List<LineSegment> res = new ArrayList<>();
        int len = points.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (points[i].equals(points[j])) continue;
                for (int k = j + 1; k < len; k++) {
                    if (points[j].equals(points[k])) continue;
                    for (int q = k + 1; q < len; q++) {
                        if (points[k].equals(points[q])) continue;
                        double sl1 = points[i].slopeTo(points[j]);
                        double sl2 = points[i].slopeTo(points[k]);
                        double sl3 = points[i].slopeTo(points[q]);

                        if (sl1 == sl2 && sl1 == sl3) {
                            res.add(new LineSegment(points[i], points[q]));
                        }
                    }
                }
            }
        }
        return res.toArray(new LineSegment[0]);
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoint collinear = new BruteCollinearPoint(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
