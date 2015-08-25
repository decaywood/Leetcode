package easy;

/**
 * @author: decaywood
 * @date: 2015/8/24 18:25
 *
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Example
 * Given input array A = [1,1,2],
 *
 * Your function should return length = 2, and A is now [1,2].
 *
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 2) return nums.length;
        int length = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) continue;
            nums[length++] = nums[i + 1];
        }
        return length;
    }

    public static void main(String[] args) {
        new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{-10, 0, 1,2,3});
    }

}
