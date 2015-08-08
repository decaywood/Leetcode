package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/8/8 10:28
 *
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j
 * in the array such that nums[i] = nums[j] and the difference
 * between i and j is at most k.
 *
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int diff = i - map.get(nums[i]);
                if(diff <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
