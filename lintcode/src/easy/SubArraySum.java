package easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: decaywood
 * @date: 2015/8/24 16:08
 *
 * Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.
 *
 * Example
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 *
 * Note
 * There is at least one subarray that it's sum equals to zero.
 *
 * 思路：hashmap记录当前index之前数的和，若下一轮循环中map里面能找到相同的和说明中间有子数组和为0
 *
 */
public class SubArraySum {

    public static ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
                continue;
            }
            res.add(map.get(sum) + 1);
            res.add(i);
            return res;
        }
        return res;
    }

    public static void main(String[] args) {
        subarraySum(new int[]{-9, 1, 2, -3, 4});
    }

}
