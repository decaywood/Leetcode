package easy;

/**
 * @author: decaywood
 * @date: 2015/11/8 14:11.
 *
 * Partition an integers array into odd number first and even number second.
 *
 * Example
 * Given [1, 2, 3, 4], return [1, 3, 2, 4]
 *
 * Challenge
 * Do it in-place.
 */
public class PartitionArrayByOddAndEven {

    public void partitionArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) left++;
            while (left < right && nums[right] % 2 == 0) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

}
