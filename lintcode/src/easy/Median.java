package easy;

/**
 * @author: decaywood
 * @date: 2015/11/8 15:06.
 *
 * Given a unsorted array with integers, find the median of it.
 *
 * A median is the middle number of the array after it is sorted.
 *
 * If there are even numbers in the array, return the N/2-th number after sorted.
 *
 * Example
 * Given [4, 5, 1, 2, 3], return 3
 *
 * Given [7, 9, 4, 5], return 5
 *
 * Challenge
 * O(n) time.
 *
 */
public class Median {

    public int median(int[] nums) {
        return median(nums, 0, nums.length - 1);
    }
    public int median(int[] nums, int start, int end) {
        if(start >= end) return nums[start];
        int index = pivot(nums, start, end);
        if(index + 1 == (nums.length + 1) / 2) return nums[index];
        return index + 1 < (nums.length + 1) / 2 ? median(nums, index + 1, end) : median(nums, start, index - 1);
    }

    public int pivot(int[] nums, int start, int end) {
        int key = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= key) end--;
            nums[start] = nums[end];
            while (start < end && nums[start] < key) start++;
            nums[end] = nums[start];
        }
        nums[start] = key;
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new Median().median(new int[]{-1,-100,-3,-100,-2,-10000,500,0,0,0,-499,500,2000,0,0,0,3000,-100,-200,-10000,100000}));
    }
}