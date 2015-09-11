package easy;

/**
 * @author: decaywood
 * @date: 2015/8/28 13:12
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Example
 * 1,1  1,2  1,3  1,4  1,5  1,6  1,7
 * 2,1
 * 3,1                           3,7
 *
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 *
 * Note
 * m and n will be at most 100.
 *
 * 思路：从左上角走到右下角，每次只能向下或者向右走一步，不管怎么走都需要m+n-2步才能走到，
 * 而这其中有m-1步是向下走，有n-1是向右走，只用从这m+n-2个位置中选择m-1个位置，则剩余的位置表示向右走。
 * 容易求得值是Cm-1m+n-2,利用杨辉三角即可。
 *
 */

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        return mChooseN(m + n - 2, Math.max(m - 1, n - 1));
    }

    private static int mChooseN(int m, int n) {
        double product = 1;
        int divisor = Math.min(n, m - n);
        for (int i = Math.max(m - n + 1, n + 1); i <= m; i++) {
            product *= i;
            if(product > divisor && divisor > 1) product /= divisor--;
        }
        return (int) Math.round(product / (divisor > 0 ? divisor : 1));
    }


}
