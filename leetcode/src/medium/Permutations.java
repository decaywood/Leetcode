package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/11/22 13:39.
 *
 * Given a collection of numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, nums, 0);
        return res;
    }

    private void permute(List<List<Integer>> res, int[] nums, int start) {
        if(start == nums.length) res.add(getList(nums));
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(res, nums, start + 1);
            swap(nums, start, i);
        }
    }

    private List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        if(i == j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Permutations().permute(new int[]{1, 2, 3});
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }

}
