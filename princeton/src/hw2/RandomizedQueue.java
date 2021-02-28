package hw2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int INITIAL_CAPACITY = 8;

    private Item[] a;
    private int size;
    private int next;

    public RandomizedQueue() {
        a = (Item[]) new Object[INITIAL_CAPACITY];
        size = 0;
        next = 0;
    }

    public int size() {
        return size;
    }

    public void resize(int capacity) {
        assert size >= capacity;
        Item[] tmp = (Item[]) new Object[capacity];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[j] != null) {
                tmp[i] = a[j];
                next = i + 1;
            }
            j++;
        }
        a = tmp;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (next == a.length) {
            if (size < next / 2) {
                resize(a.length); // Rearrange elements
            }
            else {
                resize(a.length*2);
            }
        }
        a[next++] = item;
        size++;
    }

    private void print() {
        for (Item i: a) {
            if (i == null) {
                StdOut.print("X ");
            } else {
                StdOut.print(i + " ");
            }
        }
        StdOut.println();
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();

        StdOut.println("-- Test Enqueue and Resize --");
        for (int i = 0; i < 8; i++) {
            rq.enqueue(i);
        }
        rq.print();
        for (int i = 0; i < 8; i++) {
            rq.enqueue(i);
        }
        rq.print();
        rq.enqueue(10);
        rq.print();
    }
}
