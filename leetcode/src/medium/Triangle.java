package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/8/22 11:52
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *       [2],
 *      [3,4],
 *     [6,5,7],
 *    [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * solution:自底向上计算即可
 *
 */
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        for(int i= triangle.size()-2; i>=0; i--)
            for(int j=0; j<triangle.get(i).size(); j++) {
                List<Integer> bottomLevel = triangle.get(i);
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                bottomLevel.set(j, min + bottomLevel.get(j));
            }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> levels = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        List<Integer> level2 = new ArrayList<>();
        List<Integer> level3 = new ArrayList<>();
        List<Integer> level4 = new ArrayList<>();
        level1.add(2);
        level2.add(3);
        level2.add(4);
        level3.add(6);
        level3.add(5);
        level3.add(7);
        level4.add(4);
        level4.add(1);
        level4.add(8);
        level4.add(3);
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        System.out.println(minimumTotal(levels));
    }

}
