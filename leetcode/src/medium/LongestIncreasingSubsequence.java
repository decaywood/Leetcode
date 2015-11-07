package medium;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2015/11/7 22:08.
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101],
 * therefore the length is 4. Note that there may be more than one LIS combination,
 * it is only necessary for you to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */
public class LongestIncreasingSubsequence {


    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int[] countArr = new int[nums.length];
        countArr[0] = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(sorted, num);
            int max = 0;
            for (int i = 0; i < index; i++) max = Math.max(max, countArr[i]);
            countArr[index] = max + 1;
        }
        return Arrays.stream(countArr).reduce(Math::max).getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
