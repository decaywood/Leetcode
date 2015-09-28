package medium;

/**
 * @author: decaywood
 * @date: 2015/9/27 20:04
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 *
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i <= nums.length; i++) sum += i;
        for (int i : nums) sum -= i;
        return sum;
    }

    /*public int missingNumber(int[] nums) {
        for (int i = 0, count = 0;; i++) {
            if(i == nums.length) {
                if(count == 0) break;
                count = 0;
                i %= nums.length;
            }
            if(nums[i] == nums.length || nums[i] == i) continue;
            count++;
            swap(nums, i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i) return i;
            if(i + 1 == nums.length) return nums.length;
        }
        return 0;
    }*/

   /* private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }*/


}
