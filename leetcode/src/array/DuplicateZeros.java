package array;

import edu.princeton.cs.algs4.StdOut;

public class DuplicateZeros {
    public static void duplicateZerosSlow(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] == 0) {
                for (int j = arr.length-2; j >= i + 1; j--) {
                    arr[j+1] = arr[j];
                }
                arr[i+1] = 0;
                i++;
            }
            i++;
        }
    }

    public static void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        for (int left = 0; left <= length_-possibleDups; left++) {
            if (arr[left] == 0) {

                if (left == length_ - possibleDups) { // Edge case
                    arr[length_--] = 0;
                    break;
                }

                possibleDups++;
            }
        }

        StdOut.println(possibleDups);
        StdOut.println(length_);

        int last = length_-possibleDups;
        for (int j = last; j >= 0; j--) {
            if (arr[j] == 0) {
                arr[j+possibleDups] = 0;
                possibleDups--;
                arr[j+possibleDups] = 0;
            }
            else {
                arr[j+possibleDups] = arr[j];
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1,0,2,3,0,4,5,0};
        int[] arr = {9,4,5,0,0,0,0,7};
        printArray(arr);
//        duplicateZerosSlow(arr);
        duplicateZeros(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(arr[i] + " ");
        }
        StdOut.println();
    }
}
