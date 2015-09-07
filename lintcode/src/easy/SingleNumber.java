package easy;

/**
 * @author: decaywood
 * @date: 2015/9/7 16:46
 *
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
 *
 * Example
 * Given [1,2,2,1,3,4,3], return 4
 *
 * Challenge
 * One-pass, constant extra space.
 *
 */
public class SingleNumber {

    public int singleNumber(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int n = A[0];
        for(int i = 1; i < A.length; i++) {
            n = n ^ A[i];
        }

        return n;
    }
}
