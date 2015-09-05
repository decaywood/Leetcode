package medium;

/**
 * @author: decaywood
 * @date: 2015/8/25 13:11
 *
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example
 * Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 *
 * Challenge
 * Your algorithm should run in O(n) time and uses constant space.
 *
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        if (A.length == 0) return 1;
        //��Ԫ�ط�����ȷ��λ�ã�����1����A[0]��2����A[1]...
        for (int i = 0; i < A.length; i++) {
            while (A[i] != i + 1) {
                if (A[i] >= A.length || A[i] <= 0 || A[i] == A[A[i] - 1]) break;
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }


}
