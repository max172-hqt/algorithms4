package edu.alg4.fundamentals.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))  {
                Double val1 = stack.pop();
                Double val2 = stack.pop();
                if (s.equals("+"))  stack.push(val1+val2);
                if (s.equals("-"))  stack.push(val1-val2);
                if (s.equals("*"))  stack.push(val1*val2);
                if (s.equals("/"))  stack.push(val1/val2);
            }
            else {
                stack.push(Double.parseDouble(s));
            }
        }
        StdOut.println(stack.pop());
    }
}
