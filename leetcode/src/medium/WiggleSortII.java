package medium;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2016/01/29 14:04
 *
 * Given an unsorted array nums,
 * reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 *
 * Note:
 * You may assume all input has valid answer.
 *
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(temp);
        int large = temp.length / 2 + (temp.length % 2 == 0 ? -1 : 0);
        int small = temp.length - 1;
        for (int i = 0, j = 1; i < temp.length; i += 2, j += 2) {
            if (j < temp.length) nums[j] = temp[small--];
            nums[i] = temp[large--];
        }
    }
}
