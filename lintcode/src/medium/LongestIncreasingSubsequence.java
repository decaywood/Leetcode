package medium;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2015/10/8 20:01.
 *
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 *
 * You code should return the length of the LIS.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
 *
 * For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
 *
 * Challenge
 * Time complexity O(n^2) or O(nlogn)
 *
 * Clarification
 * What's the definition of longest increasing subsequence?
 *
 * The longest increasing subsequence problem is to find a subsequence
 * of a given sequence in which the subsequence's elements are in sorted order,
 * lowest to highest, and in which the subsequence is as long as possible.
 * This subsequence is not necessarily contiguous, or unique.
 *
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problemGiven a sequence of integers,
 * find the longest increasing subsequence (LIS).
 *
 * You code should return the length of the LIS.
 *
 * Example
 * For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
 * For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
 *
 * Challenge
 * Time complexity O(n^2) or O(nlogn)
 *
 * 说明
 * 最长上升子序列的定义：
 * 最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，这种子序列不一定是连续的或者唯一的。
 *
 * 思路：要求长度为i的序列的Ai{a1,a2,……,ai}最长递增子序列，
 * 需要先求出序列Ai-1{a1,a2,……,ai-1}中以各元素(a1,a2,……,ai-1)作为最大元素的最长递增序列
 *
 */
public class LongestIncreasingSubsequence {

    /**
     * use dp
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];
        int res = 0;
        dp[0][0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[j] <= nums[i]) max = Math.max(max, dp[i - 1][j]);
                dp[i][j] = j == i ? max == 0 ? 1 : max + 1 : dp[i - 1][j];
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

}
