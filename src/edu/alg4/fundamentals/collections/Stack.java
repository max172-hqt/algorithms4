package edu.alg4.fundamentals.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    @Override
    public Iterator<Item> iterator() {
        return new StackLinkedListIterator();
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        // recursive solution
//        Node(Node<Item> x) {
//            item = x.item;
//            if (x.next != null) next = new Node<>(x.next);
//        }
        Node() { }

        // non-recursive solution
        Node(Node<Item> x) {
            item = x.item;
            next = x.next;
        }
    }

    public Stack() {
        first = null;
        n = 0;
    }

//    public Stack(Stack<Item> s) {
//        first = new Node<>(s.first);
//        n = 0;
//    }

    public Stack(Stack<Item> s) {
        if (s.first != null) {
            first = new Node<>(s.first);
            for (Node node = first; node.next != null; node = node.next) {
                node.next = new Node(node.next);
            }
        }
    }

    public boolean isEmpty()    { return first == null; }
    public int size()           { return n; }
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
    }

    private class StackLinkedListIterator implements Iterator<Item> {
        private Node<Item> current;

        public StackLinkedListIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) StdOut.println(stack.pop());
            else if (s.isEmpty()) StdOut.println("BAD INPUT");
            else stack.push(s);
        }

        for (String s: stack) {
            StdOut.print(s + " ");
        }
    }
}