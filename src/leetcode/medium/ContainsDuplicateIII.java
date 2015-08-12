package leetcode.medium;

import java.util.TreeSet;

/**
 * @author: decaywood
 * @date: 2015/8/8 10:43
 *
 * Given an array of integers, find out whether there are two distinct indices i and j
 * in the array such that the difference between nums[i] and nums[j] is at most t and
 * the difference between i and j is at most k.
 *
 *
 */
public class ContainsDuplicateIII {


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k) set.remove(Long.valueOf(nums[i - k - 1]));
            long upperBound = (long)nums[i] + t;
            long lowerBound = (long)nums[i] - t;
            Long lower = set.lower(upperBound + 1);
            if(lower != null && lower >= lowerBound) return true;
            set.add((long) nums[i]);
        }
        return false;
    }


}
