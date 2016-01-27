package medium;

/**
 * @author: decaywood
 * @date: 2016/1/26 17:05
 * 
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * nums = [
 *  [9,9,4],
 *  [6,6,8],
 *  [2,1,1]
 * ]
 *
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * Example 2:
 *  
 * nums = [
 *  [3,4,5],
 *  [3,2,6],
 *  [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 */
public class LongestIncreasingPathInAMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int max = Integer.MIN_VALUE;

        int[][] map = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int res = countPath(matrix, map, Integer.MIN_VALUE, 0, i, j);
                max = Math.max(max, res);
            }
        }
        return max;
    }

    private int countPath(int[][] matrix, int[][] map, int pre, int len, int x, int y) {
        if(x < 0 || x == matrix.length || y < 0 || y == matrix[x].length) return len;
        int current = matrix[x][y];
        if(pre < current) {
            if(map[x][y] > 0) return map[x][y] + len;
            len++;
        }
        else return len;
        int left = countPath(matrix, map, current, len, x - 1, y);
        int right = countPath(matrix, map, current, len, x + 1, y);
        int bottom = countPath(matrix, map, current, len, x, y - 1);
        int top = countPath(matrix, map, current, len, x, y + 1);
        int res = Math.max(left, Math.max(right, Math.max(bottom, top)));
        map[x][y] = res - len + 1;
        return res;
    }



}
