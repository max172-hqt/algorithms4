package edu.alg4.fundamentals.analysis;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class ThreeSumNSquare {
    public static List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    public static int[] threeSumTriplet(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (map.containsKey(target-nums[i]-nums[j]) && map.get(target-nums[i]-nums[j]) > j) {
                    return new int[] {nums[i],nums[j],target-nums[i]-nums[j]};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int sum = 9;
        int[] res = threeSumTriplet(nums, sum);
        for (int i: res) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}
