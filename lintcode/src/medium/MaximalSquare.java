package medium;

/**
 * @author: decaywood
 * @date: 2015/8/23 18:31.
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 *
 * 思路：动态规划，用数组记录当前点左下方正方形最大边长
 *
 */
public class MaximalSquare {



    public int maxSquare(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] d = new int[n][m];
        int max = 0;

        for(int i=0; i<n; i++) {
            d[i][0] = matrix[i][0];
            max = Math.max(max, matrix[i][0]);
        }
        for(int j=0; j<m; j++) {
            d[0][j] = matrix[0][j];
            max = Math.max(max, matrix[0][j]);
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(matrix[i][j] == 0) d[i][j]=0;
                else {
                    d[i][j] = Math.min( Math.min( d[i-1][j], d[i][j-1]), d[i-1][j-1] ) + 1;
                    max = Math.max(max, d[i][j]);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        int[][] s = new int[][]{new int[]{1},new int[]{1},new int[]{1},new int[]{1}};

        System.out.println(new MaximalSquare().maxSquare(s));
    }
}
