package medium;

/**
 * @author: decaywood
 * @date: 2016/05/14 10:55
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example
 * Given [3, 8, 4], return 8.
 * <p>
 * Challenge
 * O(n) time and O(1) memory.
 */
public class HouseRobber {

    public static long houseRobber(int[] A) {

        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];

        long pre1 = A[1];
        long pre2 = Math.max(A[0], A[1]);

        for (int i = 2; i < A.length; i++) {
            long temp = pre1;
            pre1 = Math.max(pre2 + A[i], pre1);
            pre2 = temp;
        }
        return pre1;
    }

    public static void main(String[] args) {
        System.out.println(houseRobber(new int[]{1,3,2,1,5}));
    }

}
