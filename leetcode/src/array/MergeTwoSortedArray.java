package array;

import edu.princeton.cs.algs4.StdOut;

public class MergeTwoSortedArray {
    public static int[] mergeTwoSortedArray(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] res = new int[a.length + b.length];

        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[k] = a[i];
                i++;
            }
            else {
                res[k] = b[j];
                j++;
            }
            k++;
        }

        if (i < a.length) {
            for (int id = i; id < a.length; id++) {
                res[k] = a[id];
                k++;
            }
        } else {
            for (int id = j; id < b.length; id++) {
                res[k] = b[id];
                k++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,16};
        int[] b = new int[]{0,9,100};
        int[] res = mergeTwoSortedArray(a,b);
        for (int i: res) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}
