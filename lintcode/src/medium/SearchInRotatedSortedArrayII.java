package medium;

/**
 * @author: decaywood
 * @date: 2015/8/28 10:51
 *
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 * Write a function to determine if a given target is in the array.
 *
 */
public class SearchInRotatedSortedArrayII {

    public static boolean search(int[] A, int target) {
        if(A.length == 0) return false;
        if(A.length == 1) return A[0] == target;
        int pivot = findPivot(A, 0, A.length - 1);
        return findTargetIndex(A, 0, pivot - 1, target) || findTargetIndex(A, pivot, A.length - 1, target);
    }

    private static int findPivot(int[] A, int left, int right) {
        if(left + 1 == right) return right;
        int mid = (left + right) / 2;
        if(A[left] > A[mid]) return findPivot(A, left, mid);
        else return findPivot(A, mid, right);
    }

    private static boolean findTargetIndex(int[] A, int left, int right, int target) {
        int mid = (left + right) / 2;
        if(left + 1 == right) return A[left] == target || (A[right] == target);
        return A[mid] == target || (A[mid] > target ? findTargetIndex(A, left, mid, target) : findTargetIndex(A, mid, right, target));
    }
}
