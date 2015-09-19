package easy;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/9/11 15:27
 *
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 *
 * Example
 * Given the array [?2,2,?3,4,?1,2,1,?5,3], the contiguous subarray [4,?1,2,1] has the largest sum = 6.
 *
 * Note
 * The subarray should contain at least one number.
 *
 * Challenge
 * Can you do it in time complexity O(n)?
 *
 */
public class MaximumSubarray {

    public int maxSubArray(ArrayList<Integer> nums) {
        int maxVal = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            sum = Math.max(num, sum);
            maxVal = Math.max(maxVal, sum);
        }
        return maxVal;
    }


}
