package medium;

/**
 * @author: decaywood
 * @date: 2015/8/25 18:57.
 *
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 *
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 *
 * Example
 * If nums = [3,2,2,1] and k=2, a valid answer is 1.
 *
 * Note
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 *
 * If all elements in nums are smaller than k, then return nums.length
 *
 * Challenge
 * Can you partition the array in-place and in O(n)?
 *
 */
public class PartitionArray {

    public static int partitionArray(int[] nums, int k) {
        if(nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == k) {
                int temp = nums[i];
                nums[i] = nums[0];
                nums[0] = temp;
                break;
            }
        }
        if(nums[0] != k) return nums[0] > k ? 0 : nums.length;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[j] >= k) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] < k) i++;
            nums[j] = nums[i];
        }
        nums[i] = k;
        return i;
    }



}
