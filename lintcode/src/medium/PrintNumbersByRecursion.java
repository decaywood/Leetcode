package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/10/23 20:42.
 *
 * Print numbers from 1 to the largest number with N digits by recursion.
 *
 * Example
 * Given N = 1, return [1,2,3,4,5,6,7,8,9].
 *
 * Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].
 *
 * Note
 * It's pretty easy to do recursion like:
 *
 * recursion(i) {
 *    if i > largest number:
 *       return
 *    results.add(i)
 *    recursion(i + 1)
 * }
 * however this cost a lot of recursion memory as the recursion depth maybe very large.
 * Can you do it in another way to recursive with at most N depth?
 *
 * Challenge
 * Do it in recursion, not for-loop.
 *
 */
public class PrintNumbersByRecursion {

    public List<Integer> numbersByRecursion(int n) {
        List<Integer> res = new ArrayList<>();
        numbersByRecursion(res, n);
        return res;
    }

    public void numbersByRecursion(List<Integer> res, int n) {
        if(n == 0) return;
        numbersByRecursion(res, n - 1);
        int low = (int) Math.pow(10, n - 1);
        int high =(int) Math.pow(10, n) - 1;
        for (int i = low; i <= high; i++) res.add(i);
    }

}
