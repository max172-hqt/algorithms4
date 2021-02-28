package edu.alg4.fundamentals.data_abstractions;

public class CircularRotation {
    public static void main(String[] args) {
        String s = args[0];
        String t = args[1];

    }

    public static boolean isCircularRotation(String s, String t) {
        return s.length() == t.length() && s.concat(s).contains(t);
    }
}
