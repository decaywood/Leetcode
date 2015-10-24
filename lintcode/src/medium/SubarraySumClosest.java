package medium;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/10/15 21:16.
 *
 * Given an integer array, find a subarray with sum closest to zero.
 * Return the indexes of the first number and last number.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
 *
 * Challenge
 * O(nlogn) time
 *
 */
public class SubarraySumClosest {

    /**
     * O(n^2)
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0, end = 0, min = Integer.MAX_VALUE;
        for (int i = 0, sum; i < nums.length; i++) {
            sum = nums[i];
            if (Math.abs(min) > Math.abs(nums[i])) start = end = i;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (Math.abs(min) > Math.abs(sum)) {
                    min = sum;
                    start = i;
                    end = j;
                }
            }
        }
        res.add(start);
        res.add(end);
        return res;

    }


}
