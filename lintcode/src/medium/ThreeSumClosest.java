package medium;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2015/8/25 14:45
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
 * target. Return the sum of the three integers.
 *
 * Example
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2.
 * (-1 + 2 + 1 = 2).
 *
 * Note
 * You may assume that each input would have exactly one solution.
 *
 * Challenge
 * O(n^2) time, O(1) extra space
 *
 * 思路：先对数组排个序。枚举第一个数，然后设两个指针，
 * 在第一个数的后半段开始王中间收缩，if sum > target则右指针往左移，
 * if sum < target则左指针往右移。
 *
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] numbers ,int target) {
        Arrays.sort(numbers);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < numbers.length; i++) {
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if (sum > target) k--;
                else if(sum < target) j++;
                else return sum;
            }
        }
        return res;
    }


}
