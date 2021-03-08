//package hw2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        if (oldFirst == null) {
            last = first;
        }
        else {
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        if (oldLast == null) {
            first = last;
        }
        else {
            oldLast.next = last;
            last.prev = oldLast;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        if (first.next != null) {
            first = first.next;
            first.prev = null;
        } else {
            first = null;
            last = null;
        }
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        if (last.prev != null) {
            last = last.prev;
            last.next = null;
        } else {
            last = null;
            first = null;
        }
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        Node<Item> curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = curr.item;
            curr = curr.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void printDeque() {
        for (Item item: this) {
            StdOut.print(item + " ");
        }
        StdOut.println();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> dq = new Deque<>();

        StdOut.println("-- Test addFirst and addLast --");
        for (int i = 0; i < 10; i++) {
            dq.addFirst(String.valueOf(i));
        }
        for (int i = 0; i < 10; i++) {
            dq.addLast(String.valueOf(i));
        }
        StdOut.println("After adding elements");
        dq.printDeque();

        StdOut.println("-- Test iterator --");
        Iterator<String> it = dq.iterator();
        StdOut.println("Next item: " + it.next());
        StdOut.println("Next item: " + it.next());
        StdOut.println("Next item: " + it.next());

        StdOut.println("-- Test removeFirst and removeLast --");
        StdOut.println("Size : " + dq.size());
        StdOut.println("Before remove");
        dq.printDeque();
        for (int i = 0; i < 5; i++) {
            dq.removeFirst();
        }
        StdOut.println("After removeFirst 5 times");
        dq.printDeque();
        StdOut.println("Size : " + dq.size());
        StdOut.println("Is queue empty : " + dq.isEmpty());
        for (int i = 0; i < 15; i++) {
            dq.removeLast();
        }
        StdOut.println("After removeLast 15 times");
        dq.printDeque();
        StdOut.println("Is queue empty : " + dq.isEmpty());

//        Check Exception
//        dq.removeFirst();
//        dq.removeLast();
//        Iterator<String> it = dq.iterator();
//        StdOut.println("Next item: " + it.next());
    }
}
