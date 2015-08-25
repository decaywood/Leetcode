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
        //把元素放入正确的位置，例如1放在A[0]，2放在A[1]...
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


    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{-1, 4, 2, 1, 9, 10}));
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{}));
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1}));
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{-1}));
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{2, 2, 2, 2}));

    }
}
