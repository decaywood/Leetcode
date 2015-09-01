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
 */
public class MajorityNumber {

    public static int majorityNumber(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0) return -1;
        for (int i = 1; i < nums.size(); i++) {
            if (!nums.get(i - 1).equals(nums.get(i)) && !nums.get(i - 1).equals(Integer.MAX_VALUE)) {
                nums.set(i - 1, Integer.MAX_VALUE);
                nums.set(i, Integer.MAX_VALUE);
            }
        }
        for (Integer num : nums) if(num != Integer.MAX_VALUE) return num;
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        int[] arr = new int[]{2,1,2,1,2};
        for (int i : arr) nums.add(i);
        System.out.println(majorityNumber(nums));
    }

}
