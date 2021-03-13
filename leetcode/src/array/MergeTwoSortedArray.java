package array;

import edu.princeton.cs.algs4.StdOut;

public class MergeTwoSortedArray {
    public static int[] mergeTwoSortedArray(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] res = new int[a.length + b.length];

        for (int k = 0; k < res.length; k++) {
            if      (i >= a.length) res[k] = b[j++];
            else if (j >= b.length) res[k] = a[i++];
            else if (a[i] < b[j])   res[k] = a[i++];
            else                    res[k] = b[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,16};
        int[] b = new int[]{0,9,100};
        int[] res = mergeTwoSortedArray(a,b);
        for (int i: res)
            StdOut.print(i + " ");
        StdOut.println();
    }
}
