package medium;

import java.awt.*;
import java.util.stream.IntStream;

/**
 * @author: decaywood
 * @date: 2015/9/26 20:23
 *
 * Given a positive integer n,
 * find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4;
 * given n = 13, return 2 because 13 = 4 + 9.
 *
 */
public class PerfectSquares {

    public static int numSquares(int n) {
        if(n <= 1) return n;
        int x = findMinBaseNum(n);
        int[][] dp = new int[x + 1][n + 1];
        for (int i = 1, squars = 1; i <= x; i++, squars = i * i) {
            for (int j = 1; j <= n; j++) {
                int count = j / squars;
                int remain = j % squars;
                dp[i][j] = i == 1 ? j : Math.min(dp[i - 1][j], count + dp[i - 1][remain]);
            }
        }
        return dp[x][n];
    }

    private static int findMinBaseNum(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }

    public static void main(String[] args) {
        IntStream.range(0, 15).mapToObj(i -> new Point(i, numSquares(i))).forEach(System.out::println);
    }

}
