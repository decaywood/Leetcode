package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/8/25 16:47
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are NOT zero-based.
 *
 * Example
 * numbers=[2, 7, 11, 15], target=9
 *
 * return [1, 2]
 *
 * Note
 * You may assume that each input would have exactly one solution
 *
 * Challenge
 * Either of the following solutions are acceptable:
 *
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 *
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>(); // Key : target - currentVal, value : relating Index
        int[] indexs = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int diff = target - num;
            if(indexMap.containsKey(diff)) {
                indexs[0] = indexMap.get(diff) + 1;
                indexs[1] = i + 1;
                return indexs;
            } else indexMap.put(num, i);
        }
        return numbers;
    }

}
