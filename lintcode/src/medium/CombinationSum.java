package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/6 19:02.
 *
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 *
 * Example
 * given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 *
 * Note
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 *
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public void combinationSum(List<List<Integer>> res, List<Integer> list, int[] candidates, int startIndex, int target) {
        if(target < 0) return;
        if(target == 0) res.add(list);
        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
            List<Integer> temp = new ArrayList<>(list);
            temp.add(num);
            combinationSum(res, temp, candidates, i, target - num);
        }
    }

}
