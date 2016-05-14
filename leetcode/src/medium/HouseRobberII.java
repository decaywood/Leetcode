package medium;

/**
 * @author: decaywood
 * @date: 2016/05/14 12:57
 * <p>
 * Note: This is an extension of House Robber.
 * <p>
 * After robbing those houses on that street,
 * the thief has found himself a new place for his thievery so that he will
 * not get too much attention. This time,
 * all houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, the security system for these houses remain the same
 * as for those in the previous street.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(houseRobber(nums, 0, nums.length - 2), houseRobber(nums, 1, nums.length - 1));
    }

    public static int houseRobber(int[] A, int start, int end) {
        int pre1 = Math.max(A[start], A[start + 1]);
        ;
        int pre2 = A[start];

        for (int i = start + 2; i <= end; i++) {
            int temp = pre1;
            pre1 = Math.max(pre2 + A[i], pre1);
            pre2 = temp;
        }
        return pre1;
    }

}
