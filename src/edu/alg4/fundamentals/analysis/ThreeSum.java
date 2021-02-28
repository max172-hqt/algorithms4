package edu.alg4.fundamentals.analysis;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = rank(nums, -nums[i]-nums[j], j + 1);
                if (k > j) {
                    List<Integer> valid = new ArrayList<>();
                    valid.add(nums[i]);
                    valid.add(nums[j]);
                    valid.add(nums[k]);
                    res.add(valid);
                }
            }
        }
        List<List<Integer>> set = new ArrayList<>(res);
        return set;
    }

    public static int threeSumCount(int[] nums) {
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = rank(nums, -nums[i]-nums[j], j + 1);
                if (k > j) cnt++;
            }
        }

        return cnt;
    }

    // Binary search
    public static int rank(int[] nums, int target, int lo) {
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == target)        return mid;
            else if (nums[mid] < target)    lo = mid + 1;
            else                            hi = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
//        int[] nums = new int[] {0,0,0};
        StdOut.println(threeSum(nums));
        StdOut.println(threeSumCount(nums));
    }
}
