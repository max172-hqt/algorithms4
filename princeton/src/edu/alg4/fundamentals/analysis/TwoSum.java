package edu.alg4.fundamentals.analysis;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int supp = target - arr[i];
            if (map.containsKey(supp) && map.get(supp) != i) {
                return new int[]{ i, map.get(supp) };
            }

            map.put(arr[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        int target = 6;

        int[] res = twoSum(nums, target);
        for (int i: res) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}
