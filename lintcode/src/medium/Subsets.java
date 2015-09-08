package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/7 21:34
 *
 * Given a set of distinct integers, return all possible subsets.
 *
 * Example
 * If S = [1,2,3], a solution is:
 *
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 * Note
 * Elements in a subset must be in non-descending order.
 *
 * The solution set must not contain duplicate subsets.
 *
 */
public class Subsets {


    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        res.add(list);
        subsets(res, list, S, 0);
        return res;
    }

    private void subsets(List<ArrayList<Integer>> res, List<Integer> list, List<Integer> S, int start) {
        for (int i = start; i < S.size(); i++) {
            int num = S.get(i);
            ArrayList<Integer> temp = new ArrayList<>(list);
            temp.add(num);
            res.add(temp);
            subsets(res, temp, S, i + 1);
        }
    }

}
