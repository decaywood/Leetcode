package medium;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/10/16 13:32
 *
 * Given an integer array, find a continuous subarray where the sum of numbers is the biggest.
 * Your code should return the index of the first number and the index of the last number.
 * (If their are duplicate answer, return anyone)
 *
 * Example
 * Give [-3, 1, 3, -3, 4], return [1,4].
 *
 */
public class ContinuousSubarraySum {

    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
        int start = 0, sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            start = num > sum + num ? i : start;
            sum = Math.max(num, sum + num);
            if (max < sum) {
                max = sum;
                res.set(0, start);
                res.set(1, i);
            }
        }

        return res;
    }



}
