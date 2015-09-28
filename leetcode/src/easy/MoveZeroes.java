package easy;

/**
 * @author: decaywood
 * @date: 2015/9/26 19:37
 *
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 *
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) if(num != 0) nums[index++] = num;
        for (int i = index; i < nums.length; i++) nums[i] = 0;
    }

}
