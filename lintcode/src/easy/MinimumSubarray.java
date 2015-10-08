package easy;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/10/8 13:23
 *
 * Given an array of integers, find the subarray with smallest sum.
 *
 * Return the sum of the subarray.
 *
 * Example
 * For [1, -1, -2, 1], return -3
 *
 * Note
 * The subarray should contain at least one integer.
 *
 */
public class MinimumSubarray {

    public int minSubArray(ArrayList<Integer> nums) {
        int min = Integer.MAX_VALUE;
        int temp = 0;
        for (Integer num : nums) {
            temp = Math.min(num, temp + num);
            min = Math.min(min, temp);
        }
        return min;
    }

}
