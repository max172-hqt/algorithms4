package edu.alg4.fundamentals.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix {
    public static String infixToPostfix(String s) {
        Stack<Character> operators = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for (Character c: s.toCharArray()) {
            if (c == '+')       operators.push(c);
            else if (c == '-')  operators.push(c);
            else if (c == '*')  operators.push(c);
            else if (c == '/')  operators.push(c);
            else if (c == '(' || c == ' ') ;
            else if (c == ')') {
                char ops = operators.pop();
                sb.append(ops + " ");
            }
            else {
                sb.append(c + " ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readAll();
            StdOut.println(infixToPostfix(s));
        }
    }
}
