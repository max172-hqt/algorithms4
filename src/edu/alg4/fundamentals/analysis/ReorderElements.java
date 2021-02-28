package edu.alg4.fundamentals.analysis;

import edu.princeton.cs.algs4.StdOut;

public class ReorderElements {
    // arr[] = [10,11,12]
    // index[] = [1,0,2]

    // arr[] = [11,10,12]
    // index[] = [0,1,2]

    public static Object[] reorderElements(int[] arr, int[] index) {
        for (int i=0; i<index.length; i++) {
            while (index[i] != i) {
                int tmp = index[i];
                int tmpVal = arr[i];
                index[i] = index[tmp];
                index[tmp] = tmp;

                arr[i] = arr[tmp];
                arr[tmp] = tmpVal;
            }
        }
        return new Object[]{arr, index};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,11,12};
        int[] index = new int[]{1,0,2};
        reorderElements(arr, index);
        for (int i: arr) {
            StdOut.print(i + " ");
        }

        StdOut.println();
        for (int i: index) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}
