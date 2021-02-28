package leetcode.array;

import edu.princeton.cs.algs4.StdOut;

public class InsertArray {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            StdOut.println("Index " + i + " contains " + arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] intArray = new int[6];
        int length = 0;

        for (int i = 0; i < 3; i++) {
            intArray[i] = i;
            length++;
        }

        intArray[length] = 10;
        length++;

        for (int i = 3; i >=0; i--) {
            intArray[i+1] = intArray[i];
        }

        intArray[0] = 4;
        printArray(intArray);

        // Insert anywhere

    }
}
