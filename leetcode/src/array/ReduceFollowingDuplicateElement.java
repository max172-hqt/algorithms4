package array;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class ReduceFollowingDuplicateElement {
    public static List<List<Object>> reduceFollowingDuplicateElement(char[] arr) {
        List<List<Object>> res = new ArrayList<>();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i-1]) {
                list = new ArrayList<>();
                list.add(arr[i]);
                list.add(1);
                res.add(list);
            } else {
                list.set(1, (int)list.get(1)+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'a','a','b','b','c','a','b','c'};
        List<List<Object>> res = reduceFollowingDuplicateElement(arr);
        StdOut.println(res);
    }
}
