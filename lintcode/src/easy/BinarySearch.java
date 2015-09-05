package easy;

/**
 * @author: decaywood
 * @date: 2015/8/26 21:27.
 *
 * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
 *
 * If the target number does not exist in the array, return -1.
 *
 * Example
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 *
 * Challenge
 * If the count of numbers is bigger than 2^32, can your code work properly?
 *
 */
public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left < right) {
            int middle = (left + right) / 2;
            int num = nums[middle];
            if(right - left <= 2 || num == target) {
                index = nums[left] == target ? left : nums[middle] == target ? middle : right;
                break;
            }
            left = num > target ? left : middle + 1;
            right = num > target ? middle - 1 : right;
        }
        if(nums[index] != target) return -1;
        while (index - 1 >= 0 && nums[index - 1] == nums[index]) index--;
        return index;
    }



}
