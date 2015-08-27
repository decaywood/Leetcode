package medium;

/**
 * @author: decaywood
 * @date: 2015/8/27 20:37.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 *
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 *
 * Challenge
 * O(logN) time
 *
 *
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] A, int target) {
        if(A.length == 0) return -1;
        if(A.length == 1) return A[0] == target ? 0 : -1;
        int pivot = findPivot(A, 0, A.length - 1);
        int res = findTargetIndex(A, 0, pivot - 1, target);
        return res != -1 ? res : findTargetIndex(A, pivot, A.length - 1, target);
    }

    private static int findPivot(int[] A, int left, int right) {
        if(left + 1 == right) return right;
        int mid = (left + right) / 2;
        if(A[left] > A[mid]) return findPivot(A, left, mid);
        else return findPivot(A, mid, right);
    }

    private static int findTargetIndex(int[] A, int left, int right, int target) {
        int mid = (left + right) / 2;
        if(left + 1 == right) return A[left] == target ? left : A[right] == target ? right : -1;
        return A[mid] == target ? mid : A[mid] > target ? findTargetIndex(A, left, mid, target) : findTargetIndex(A, mid, right, target);
    }


}
