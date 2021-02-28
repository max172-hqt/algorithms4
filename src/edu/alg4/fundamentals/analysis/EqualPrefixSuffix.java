package edu.alg4.fundamentals.analysis;

import edu.princeton.cs.algs4.StdOut;

public class EqualPrefixSuffix {
    public static int equalPrefixSuffix(int[] arr) {
        int total = 0;
        for (int i=0; i<arr.length; i++) {
            total += arr[i];
        }

        int max = Integer.MIN_VALUE;

        int left = 0;
        for (int i=0; i<arr.length; i++) {
            left += arr[i];
            if (total - left + arr[i] == left && left > max) max = left;
        }

        return max;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,2,3,0,3,2,-1};
        int[] nums = new int[]{-2,5,3,1,2,6,-4,2};
        StdOut.println(equalPrefixSuffix(nums));
    }
}
