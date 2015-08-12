package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Given an array of integers, find two numbers such that they add up to a
     * specific target number. The function twoSum should return indices of the
     * two numbers such that they add up to the target, where index1 must be
     * less than index2. Please note that your returned answers (both index1 and
     * index2) are not zero-based. You may assume that each input would have
     * exactly one solution. Input: numbers={2, 7, 11, 15}, target=9 Output:
     * index1=1, index2=2
     * 
     */

    public static int[] twoSum(int[] numbers, int target) {
        int[] indexs = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 1;
        for (int num : numbers) {

            if (map.containsKey(num)) {
                indexs[0] = Math.min(i, map.get(num));
                indexs[1] = Math.max(i, map.get(num));
                break;
            }
            map.put(target - num, i);
            i++;
        }

        return indexs;
    }

    public static void main(String[] args) {
        twoSum(new int[] { 0, 4, 3, 0 }, 0);
    }

}
