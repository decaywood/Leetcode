package easy;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/9/11 14:04
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * Example
 * For example, given the following triangle
 *
 * [
 *  [2],
 *  [3,4],
 *  [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 */
public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = 0; i + 1 < triangle.size(); i++) {
            ArrayList<Integer> arr = triangle.get(i);
            ArrayList<Integer> nextArr = triangle.get(i + 1);
            for (int j = 0; j < nextArr.size(); j++) {
                int num = j >= arr.size() ? Integer.MAX_VALUE : arr.get(j);
                int left = j == 0 ? Integer.MAX_VALUE : arr.get(j - 1);
                nextArr.set(j, nextArr.get(j) + Math.min(num, left));
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer integer : triangle.get(triangle.size() - 1)) {
            min = Math.min(min, integer);
        }
        return min;
    }



}
