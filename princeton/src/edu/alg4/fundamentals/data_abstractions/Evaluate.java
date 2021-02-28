package edu.alg4.fundamentals.data_abstractions;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+"))     ops.push(s);
            else if (s.equals("-"))     ops.push(s);
            else if (s.equals("*"))     ops.push(s);
            else if (s.equals("/"))     ops.push(s);
            else if (s.equals("sqrt"))  ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                if (!op.equals("sqrt")) {
                    Double val1 = vals.pop();
                    Double val2 = vals.pop();
                    if (op.equals("+"))    vals.push(val2 + val1);
                    if (op.equals("-"))    vals.push(val2 - val1);
                    if (op.equals("*"))    vals.push(val2 * val1);
                    if (op.equals("/"))    vals.push(val2 / val1);
                }
                else {
                    Double val = vals.pop();
                    vals.push(Math.sqrt(val));
                }
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
