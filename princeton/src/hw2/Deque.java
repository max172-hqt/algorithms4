package hw2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;
    }

    Node<Item> first = null;
    Node<Item> last = null;
    int size = 0;

    // construct an empty deque
    public Deque() {}

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
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> dq = new Deque<>();
        dq.addLast("a");
        dq.addLast("b");
        dq.removeFirst();

        for (String item: dq) {
            StdOut.print(item + " ");
        }
        StdOut.println();
    }
}
