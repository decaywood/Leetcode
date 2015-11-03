package medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2015/11/3 13:18
 *
 * Give you an integer array (index from 0 to n-1,
 * where n is the size of this array, value from 0 to 10000) and an query list.
 * For each query, give you an integer,
 * return the number of element in the array that are smaller that the given integer.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]
 *
 * Note
 * We suggest you finish problem Segment Tree Build and Segment Tree Query II first.
 *
 * Challenge
 * Could you use three ways to do it.
 *
 * Just loop
 * Sort and binary search
 * Build Segment Tree and Search.
 *
 */
public class CountOfSmallerNumber {

    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        Arrays.sort(A);
        ArrayList<Integer> res = new ArrayList<>();
        for (int query : queries) {
            res.add(smaller(A, 0, A.length, query));
        }
        return res;
    }

    private int smaller(int[] arr, int start, int end, int i) {
        if(arr.length == 0) return 0;
        if(end == arr.length && arr[arr.length - 1] < i) return arr.length;
        if(start + 1 == end) return arr[start] >= i ? start : end;
        int mid = start + (end - start) / 2;
        return arr[mid] >= i ? smaller(arr, start, mid, i) : smaller(arr, mid, end, i);
    }


}
