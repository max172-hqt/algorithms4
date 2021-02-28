package edu.alg4.fundamentals.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    public static final char LEFT_BRACKET = '[';
    public static final char RIGHT_BRACKET = ']';
    public static final char LEFT_PAREN = '(';
    public static final char RIGHT_PAREN = ')';
    public static final char LEFT_BRACE = '{';
    public static final char RIGHT_BRACE = '}';

    public static boolean isBalance(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (c == LEFT_BRACE || c == LEFT_BRACKET || c == LEFT_PAREN) {
                stack.push(c);
            }
            else if (c == RIGHT_BRACE) {
                if (stack.isEmpty()) return false;
                if (LEFT_BRACE != stack.pop()) return false;
            }
            else if (c == RIGHT_PAREN) {
                if (stack.isEmpty()) return false;
                if (LEFT_PAREN != stack.pop()) return false;
            }
            else if (c == RIGHT_BRACKET) {
                if (stack.isEmpty()) return false;
                if (LEFT_BRACKET != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            StdOut.println(isBalance(s));
        }
    }
}
