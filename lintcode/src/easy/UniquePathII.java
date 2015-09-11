package easy;

/**
 * @author: decaywood
 * @date: 2015/9/11 10:21
 *
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Example
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 *
 */
public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) return 0;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? Integer.MAX_VALUE : 0;
                if(obstacleGrid[i][j] == Integer.MAX_VALUE) continue;
                int top = i - 1 < 0 ? j == 0 ? 1 : 0 :obstacleGrid[i - 1][j] == Integer.MAX_VALUE ? 0 : obstacleGrid[i - 1][j];
                int left = j - 1 < 0 ? 0 : obstacleGrid[i][j - 1] == Integer.MAX_VALUE ? 0 : obstacleGrid[i][j - 1];
                obstacleGrid[i][j] = top + left;
            }
        }
        int res = obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
