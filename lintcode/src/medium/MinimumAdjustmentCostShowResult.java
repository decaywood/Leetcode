package medium;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/10/8 13:31
 *
 * Given an integer array, adjust each integers so that the difference of
 * every adjacent integers are not greater than a given number target.
 *
 * If the array before adjustment is A, the array after adjustment is B,
 * you should minimize the sum of |A[i]-B[i]|
 *
 * Example
 * Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3],
 * the adjustment cost is 2 and it's minimal.
 *
 * Return 2.
 *
 * Note
 * You can assume each number in the array is a positive integer and not greater than 100.
 *
 */
public class MinimumAdjustmentCostShowResult {

        public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
            int[][] dp = new int[A.size()][100];
            for (int i = 0; i < 100; i++) {
                dp[0][i] = Math.abs(A.get(0) - i);
            }
            for (int i = 1; i < A.size(); i++) {
                int[] row = dp[i - 1];
                for (int j = 0; j < 100; j++) {
                    int diff = Math.abs(A.get(i) - j);
                    int min = Integer.MAX_VALUE;
                    for (int k = Math.max(j - target, 0); k < Math.min(j + target + 1, 100); k++){
                        min = Math.min(min, diff + row[k]);
                    }

                    dp[i][j] = min;
                }
            }
            int min = dp[A.size() - 1][0];
            for (int i : dp[A.size() - 1]) {
                min = Math.min(min, i);
            }
            return min;
        }


}
