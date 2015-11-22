package easy;

/**
 * @author: decaywood
 * @date: 2015/11/22 13:25.
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 */
public class RangeSumQueryImmutable {

    private int[] sums;

    public RangeSumQueryImmutable(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j] - (i == 0 ? 0 : sums[i - 1]);
    }

}
