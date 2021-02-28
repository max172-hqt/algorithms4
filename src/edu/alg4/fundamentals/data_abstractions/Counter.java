package edu.alg4.fundamentals.data_abstractions;

import edu.princeton.cs.algs4.StdOut;

public class Counter {
    private final String name;
    private int count;

    public Counter(String id) {
        name = id;
    }

    public void increment() { count++; }

    public int tally() { return count; }

    @Override
    public String toString() {
        return "Counter{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {
        Counter head = new Counter("heads");
        Counter tail = new Counter("tails");

        head.increment();
        head.increment();
        tail.increment();

        StdOut.println(head + " " + tail);
        StdOut.println(head.tally() + " " + tail.tally());
    }
}
