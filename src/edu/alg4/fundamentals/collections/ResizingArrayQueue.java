package edu.alg4.fundamentals.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> implements Iterable<Item> {
    private static final int INIT_CAPACITY = 8;

    private Item[] Q;
    private int n; // Current number of items
    private int first;
    private int last;

    public ResizingArrayQueue() {
        Q = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty()    { return n == 0; }
    public int size()           { return n; }

    public void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = Q[(first + i) % Q.length];
        }
        Q = copy;
        first = 0;
        last = n;
    }

    public void enqueue(Item item) {
        if (n == Q.length) {
            resize(Q.length * 2);
        }
        Q[last++] = item;
        if (last == Q.length) {
            last = 0;
        }
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        Item ret = Q[first];
        Q[first] = null;
        first++;
        n--;
        if (first == Q.length) {
            first = 0;
        }
        if (n > 0 && n == Q.length / 4)  {
            resize(Q.length / 2);
        }
        return ret;
    }

    public Iterator<Item> iterator() {
        return new ArrayQueueIterator();
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return Q[first];
    }

    private class ArrayQueueIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = Q[(first + i) % Q.length];
            i++;
            return item;
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
            else StdOut.println("Queue is empty");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
        for (String s: queue) {
            StdOut.print(s + " ");
        }
    }
}
