package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: decaywood
 * @date: 2015/9/7 21:48
 *
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 *
 * Example
 * For numbers [1,2,2] the unique permutations are:
 *
 * [
 *  [1,2,2],
 *  [2,1,2],
 *  [2,2,1]
 * ]
 *
 * Challenge
 * Do it without recursion.
 *
 */
public class PermutationsII {



    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        permuteUnique(res, nums, 0);
        return res;
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums, int start) {
        if(start >= nums.size()) res.add(new ArrayList<Integer>(nums));
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.size(); i++) {
            if(set.contains(nums.get(i))) continue;
            set.add(nums.get(i));
            swap(nums, start, i);
            permuteUnique(res, nums, start + 1);
            swap(nums, start, i);
        }
        return res;
    }

    private void swap(ArrayList<Integer> nums, int i, int j) {
        Integer temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

}
