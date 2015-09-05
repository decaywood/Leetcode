package medium;

/**
 * @author: decaywood
 * @date: 2015/8/27 12:49
 *
 * There is an integer array which has the following features:
 *
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peek if:
 *
 * A[P] > A[P-1] && A[P] > A[P+1]
 * Find a peak element in this array. Return the index of the peak.
 *
 * Example
 * Given [1, 2, 1, 3, 4, 5, 7, 6]
 *
 * Return index 1 (which is number 2) or 6 (which is number 7)
 *
 * Note
 * The array may contains multiple peeks, find any of them.
 *
 * Challenge
 * Time complexity O(logN)
 *
 *
 */
public class FindPeakElement {

    public static int findPeak(int[] A) {
        return findPeak(A, 0, A.length - 1);
    }

    public static int findPeak(int[] A, int left, int right) {
        if(left == right) return left;
        int mid = (right + left) / 2;
        if(A[mid] > A[mid + 1])
            return findPeak(A, left, mid);
        else
            return findPeak(A, mid + 1, right);
    }


}
