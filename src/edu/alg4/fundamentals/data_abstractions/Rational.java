package edu.alg4.fundamentals.data_abstractions;

import edu.princeton.cs.algs4.StdOut;

public class Rational implements Comparable<Rational> {
    private final static Rational zero = new Rational(0, 1);
    private long num;
    private long den;

    public long numerator() { return num; }
    public long denominator() { return den; }

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator is zero");
        }
        long gcd = gcd(numerator, denominator);

        num = numerator / gcd;
        den = denominator / gcd;

        if (den < 0) {
            den = -den;
            num = -num;
        }
    }

    @Override
    public int compareTo(Rational that) {
        long lhs = this.num * that.den;
        long rhs = this.den * that.num;
        return Long.compare(lhs, rhs);
    }

    public Rational plus(Rational that) {
        if (that.compareTo(zero) == 0) return this;
        if (this.compareTo(zero) == 0) return that;

        long f = gcd(this.num, that.num);
        long g = gcd(this.den, that.den);

        Rational s = new Rational(
            (this.num/f * that.den/g) + (that.num/f * this.den/g),
            this.den * (that.den/g)
        );

        s.num *= f;
        return s;
    }

    @Override
    public String toString() {
        if (den == 1) return num + "";
        return num + "/" + den;
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Rational that = (Rational) other;
        return this.compareTo(that) == 0;
    }

    private static long gcd(long a, long b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        return a * (b / gcd(a, b));
    }

    public static void main(String[] args) {
        Rational a = new Rational(4, 12);
        Rational b = new Rational(1, 2);

        StdOut.println(a);
        StdOut.println(a.plus(b));
    }

}
