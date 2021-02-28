package array;

import edu.princeton.cs.algs4.StdOut;

public class ReplaceElementRightSide {
//    Input: arr = [17,18,5,4,6,1]
//    Output: [18,6,6,6,1,-1]
//    Explanation:
//            - index 0 --> the greatest element to the right of index 0 is index 1 (18).
//            - index 1 --> the greatest element to the right of index 1 is index 4 (6).
//            - index 2 --> the greatest element to the right of index 2 is index 4 (6).
//            - index 3 --> the greatest element to the right of index 3 is index 4 (6).
//            - index 4 --> the greatest element to the right of index 4 is index 5 (1).
//            - index 5 --> there are no elements to the right of index 5, so we put -1.

    public static int[] replaceElements(int[] arr) {
        int current_max = -1;
        for (int i=arr.length-1; i>=0; i--) {
            int tmp = arr[i];
            arr[i] = current_max;
            if (tmp > current_max) current_max = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {17,18,5,4,6,1};
        replaceElements(nums);

        for (int i: nums) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}
