package easy;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2015/8/11 16:10
 *
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can,
 * there are at least 3 different ways to solve this problem.
 */
public class RotateArray {


    public static void rotate(int[] nums, int k) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++)
            nums[(i + k) % nums.length] = temp[i];
    }


}
