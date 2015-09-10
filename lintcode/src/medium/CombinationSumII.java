package medium;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/9/10 18:
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Example
 * For example, given candidate set 10,1,6,7,2,1,5 and target 8,
 *
 * A solution set is:
 * [1,7]
 * [1,2,5]
 * [2,6]
 * [1,1,6]
 *
 * Note
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 *
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        combinationSum2(num, res, new ArrayList<Integer>(), 0, target);
        return res;
    }

    public void combinationSum2(int[] num, List<List<Integer>> res, List<Integer> list, int start, int target) {
        if(target == 0) {
            res.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; num != null && i < num.length; i++) {
            int val = num[i];
            if(set.contains(val)) continue;
            set.add(val);
            if(target - val < 0) break;
            List<Integer> temp = new ArrayList<>(list);
            temp.add(val);
            combinationSum2(num, res, temp, i + 1, target - val);
        }
    }

    public static void main(String[] args) {
        new CombinationSumII().combinationSum2(new int[]{10,1,6,7,2,1,5}, 8);
    }


}
