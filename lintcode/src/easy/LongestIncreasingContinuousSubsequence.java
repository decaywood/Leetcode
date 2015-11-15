package easy;

/**
 * @author: decaywood
 * @date: 2015/11/8 13:18.
 *
 * Give you an integer array (index from 0 to n-1, where n is the size of this array)，
 * find the longest increasing continuous subsequence in this array.
 * (The definition of the longest increasing continuous subsequence here can be from right to left or from left to right)
 *
 * Example
 * For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 *
 * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 *
 * Note
 * O(n) time and O(1) extra space.
 *
 */
public class LongestIncreasingContinuousSubsequence {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        if(A.length == 0) return 0;
        int max = 1;
        int pre = A[0];
        for (int i = 1, count = 1; i < A.length; i++) {
            int num = A[i];
            if(num > pre) count++;
            else count = 1;
            pre = num;
            max = Math.max(max, count);
        }
        pre = A[A.length - 1];
        for (int i = A.length - 2, count = 1; i >= 0; i--) {
            int num = A[i];
            if(num > pre) count++;
            else count = 1;
            pre = num;
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        new LongestIncreasingContinuousSubsequence().longestIncreasingContinuousSubsequence(new int[]{5, 4, 2, 1, 3});
    }

}
