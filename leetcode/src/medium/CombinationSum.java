package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/29 18:54
 *
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 *
 */
public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    public void combinationSum(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(list);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target - candidate < 0) continue;
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidate);
            combinationSum(res, temp, candidates, target - candidate, i);
        }
    }

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7);
    }

}
