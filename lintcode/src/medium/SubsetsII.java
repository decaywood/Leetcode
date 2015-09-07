package medium;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/9/7 14:06
 *
 * Given a list of numbers that may has duplicate numbers, return all possible subsets
 *
 * Have you met this question in a real interview? Yes
 * Example
 * If S = [1,2,2], a solution is:
 *
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 * Note
 * Each element in a subset must be in non-descending order.
 *
 * The ordering between two subsets is free.
 *
 * The solution set must not contain duplicate subsets.
 *
 */
public class SubsetsII {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        res.add(list);
        subsetsWithDup(res, list, S, 0);
        return res;
    }

    public void subsetsWithDup(ArrayList<ArrayList<Integer>> res, List<Integer> list, ArrayList<Integer> S, int start) {
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < S.size(); i++) {
            int num = S.get(i);
            if(set.contains(num)) continue;
            set.add(num);
            ArrayList<Integer> temp = new ArrayList<>(list);
            temp.add(num);
            res.add(temp);
            subsetsWithDup(res, temp, S, i + 1);
        }
    }


}
