package easy;

/**
 * @author: decaywood
 * @date: 2015/8/23 15:33.
 *
 * Given a boolean 2D matrix, find the number of islands.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given graph:
 *
 * [
 * [1, 1, 0, 0, 0],
 * [0, 1, 0, 0, 1],
 * [0, 0, 0, 1, 1],
 * [0, 0, 0, 0, 0],
 * [0, 0, 0, 0, 1]
 * ]
 * return 3.
 *
 * Note
 * 0 is represented as the sea, 1 is represented as the island.
 * If two 1 is adjacent, we consider them in the same island.
 * We only consider up/down/left/right adjacent.
 *
 */
public class NumberOfIslands {

    public int numIslands(boolean[][] grid) {
        if(grid == null) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!grid[i][j]) continue;
                count++;
                clearIsland(grid, grid.length, grid[0].length,  i, j);
            }
        }
        return count;
    }

    private void clearIsland(boolean[][] grid, int row, int column, int i, int j) {
        if(i < 0 || j < 0 || i == row || j == column || !grid[i][j]) return;
        grid[i][j] = false;
        clearIsland(grid, row, column, i, j + 1);
        clearIsland(grid, row, column, i + 1, j);
        clearIsland(grid, row, column, i - 1, j);
        clearIsland(grid, row, column, i, j - 1);
    }

}
