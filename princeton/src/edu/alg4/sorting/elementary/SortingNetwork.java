package edu.alg4.sorting.elementary;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SortingNetwork {
    public static void main(String[] args) {
        int[] nums = new int[3];
        int i = 0;
        while (! StdIn.isEmpty()) {
            if (i > 2) throw new IllegalArgumentException();
            nums[i] = StdIn.readInt();
            i++;
        }

        if (nums[0] > nums[1]) exch(nums, 0, 1);
        if (nums[0] > nums[2]) exch(nums, 0, 2);
        if (nums[1] > nums[2]) exch(nums, 1, 2);

        for (int j = 0; j < 3; j++) {
            StdOut.print(nums[j] + " ");
        }
        StdOut.println();
    }

    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
