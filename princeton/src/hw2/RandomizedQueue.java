package hw2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int INITIAL_CAPACITY = 8;

    private Item[] a;
    private int n;

    public RandomizedQueue() {
        a = (Item[]) new Object[INITIAL_CAPACITY];
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void resize(int capacity) {
        assert n >= capacity;
        Item[] tmp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (n == a.length) {
            resize(a.length*2);
        }
        a[n++] = item;
    }

    // Remove and return random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int randId = StdRandom.uniform(0, n-1);
        Item item = a[randId];
        a[randId] = a[--n];
        a[n] = null; // Avoid loitering
        if (n <= a.length/4) {
            resize(a.length/2);
        }

        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int randId = StdRandom.uniform(0, n-1);
        Item item = a[randId];
        return item;
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
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int curr;
        private Item[] tmp;
        public RandomizedQueueIterator() {
            curr = 0;
            tmp = (Item[]) new Object[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = a[i];
            }
            StdRandom.shuffle(tmp);
        }

        @Override
        public boolean hasNext() {
            return curr < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = tmp[curr++];
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();

        StdOut.println("-- Test Enqueue and Resize --");
        for (int i = 1; i <= 5; i++) {
            rq.enqueue(i);
        }

        rq.print();
        rq.enqueue(6);

        for (int a: rq) {
            for (int b: rq) {
                StdOut.print(a + " - " + b + " ");
            }
            StdOut.println();
        }
//        for (int i = 0; i < 8; i++) {
//            rq.enqueue(i);
//        }
//        rq.print();
//        rq.enqueue(10);
//        rq.print();
//        rq.print();
//        for (int i = 0; i < 8; i++) {
//            rq.enqueue(i);
//        }
////        for (int i = 0; i < 20; i++) {
////            rq.dequeue();
////        }
//        rq.print();
//        rq.dequeue();
//        rq.dequeue();
//        rq.dequeue();
//        rq.dequeue();
//        rq.dequeue();
//        rq.dequeue();
//        rq.dequeue();
//        rq.enqueue(10);
//        rq.enqueue(11);
//        rq.enqueue(12);
//        rq.print();
        StdOut.print(rq.sample());
    }

}
