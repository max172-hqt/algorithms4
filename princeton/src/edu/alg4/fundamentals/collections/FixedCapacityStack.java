package edu.alg4.fundamentals.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] A;
    private int N;

    public FixedCapacityStack(int capacity) {
        A = (Item[]) new Object[capacity];
        N = 0;
    }

    public boolean isEmpty()    { return N == 0; }
    public int size()           { return N; }
    public void push(Item item) { A[N++] = item; }
    public Item pop()           { return A[--N]; }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N - 1;

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            return A[i--];
        }
    }

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStack<String> stack = new FixedCapacityStack<String>(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (stack.isEmpty())  StdOut.println("BAD INPUT");
            else                       StdOut.print(stack.pop() + " ");
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
