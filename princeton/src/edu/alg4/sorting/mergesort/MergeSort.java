package edu.alg4.sorting.mergesort;

import edu.princeton.cs.algs4.StdOut;

public class MergeSort {
    private static final int CUT_OFF = 7; // cut off to insertion sort
    private static Comparable[] aux;

    MergeSort() {}

    public static void bottomUpSort(Comparable[] a) {
        aux = new Comparable[a.length];
        int n = a.length;
        for (int sz = 1; sz < n; sz = sz+sz) {
            for (int lo = 0; lo < n-sz; lo += sz+sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
            }
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        if (less(a[mid], a[mid+1])) return;
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        if (hi <= lo + CUT_OFF) {
            insertionSort(a, lo, hi);
            return;
        }

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else                           a[k] = aux[j++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (!less(a[i], a[i-1])) return false;
        }
        return true;
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) exch(a, j, j-1);
            }
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] a = {1,4,6,3,2,5,3,5,7,8,3,2,23,4,6,7};
        MergeSort.sort(a);
        show(a);
    }
}
