package medium;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/9/8 12:20
 *
 * Given a list of numbers, return all possible permutations.
 *
 * Example
 * For nums = [1,2,3], the permutations are:
 *
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 * Challenge
 * Do it without recursion.
 *
 */
public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums == null) return res;
        permuteUnique(res, nums, 0);
        return res;
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums, int start) {
        if(start >= nums.size()) res.add(new ArrayList<Integer>(nums));
        for (int i = start; i < nums.size(); i++) {
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
