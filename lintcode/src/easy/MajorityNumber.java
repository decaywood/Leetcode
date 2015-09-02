package easy;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/9/1 9:33
 *
 * Given an array of integers, the majority number is the
 * number that occurs more than half of the size of the array. Find it.
 *
 * Example
 * Given [1, 1, 1, 1, 2, 2, 2], return 1
 *
 * Challenge
 * O(n) time and O(1) extra space
 *
 * 思路：同时删除两个元素，如果有一个元素超过半数则必定为candidate
 *
 * 例如：[1, 1, 1, 1, 2, 3, 4] 通过计算，1的count至少为1，即为candidate
 *
 */
public class MajorityNumber {

    public static int majorityNumber(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0) return -1;
        int candidate = nums.get(0);
        int count = 1;
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            if(count == 0) candidate = num;
            if(candidate == num) count++;
            else count--;
        }
        return candidate;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        int[] arr = new int[]{2,2,2,2,1,1,1,1,1};
        for (int i : arr) nums.add(i);
        System.out.println(majorityNumber(nums));
    }

}
