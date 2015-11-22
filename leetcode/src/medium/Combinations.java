package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/11/22 16:58.
 *
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 *
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    public void combine(List<List<Integer>> res, List<Integer> list, int start, int n, int k) {
        if(k == list.size()) {
            res.add(list);
            return;
        }

        for (int i = start; i <= n; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(i);
            combine(res, temp, i + 1, n, k);
        }
    }


}
