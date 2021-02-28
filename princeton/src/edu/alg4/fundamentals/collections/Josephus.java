package edu.alg4.fundamentals.collections;

import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < M - 1; i++) {
                queue.enqueue(queue.dequeue()); // Put M - 1 items to the end of the queue
            }
            StdOut.print(queue.dequeue() + " "); // eliminate Mth item until the queue is empty
        }
    }
}
