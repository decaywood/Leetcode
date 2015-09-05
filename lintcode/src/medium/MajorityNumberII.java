package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/2 10:03.
 *
 * Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.
 *
 * Find it.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given [1, 2, 1, 2, 1, 3, 3], return 1.
 *
 * Note
 * There is only one majority number in the array.
 *
 * Challenge
 * O(n) time and O(1) extra space.
 *
 * 思路：正如算法Majority Number，同时删除两个元素，现在同时删除三个元素。
 *
 */
public class MajorityNumberII {

    public static int majorityNumber(List<Integer> nums) {
        int candidate1 = Integer.MAX_VALUE, candidate2 = Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;
        for (Integer num : nums) {
            if (count1 != 0 && candidate1 == num) count1++;
            else if (count2 != 0 && candidate2 == num) count2++;
            else if (count1 != 0 && count2 != 0) {
                count1--;
                count2--;
            } else if (count1 == 0) {
                count1 = 1;
                candidate1 = num;
            } else {
                count2 = 1;
                candidate2 = num;
            }
        }
        count1 = 0;
        count2 = 0;
        for (Integer num : nums) {
            if (candidate1 == num) count1++;
            else if (candidate2 == num) count2++;
        }
        return count1 > count2 ? candidate1 : candidate2;
    }


}
