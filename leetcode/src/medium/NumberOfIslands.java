package medium;

/**
 * @author: decaywood
 * @date: 2015/8/23 19:29.
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 *
 * Example 2:
 *
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 *
 */
public class NumberOfIslands {


    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') continue;
                count++;
                clearIsland(grid, grid.length, grid[0].length,  i, j);
            }
        }
        return count;
    }

    private void clearIsland(char[][] grid, int row, int column, int i, int j) {
        if(i < 0 || j < 0 || i == row || j == column || grid[i][j] == '0') return;
        grid[i][j] = '0';
        clearIsland(grid, row, column, i, j + 1);
        clearIsland(grid, row, column, i + 1, j);
        clearIsland(grid, row, column, i - 1, j);
        clearIsland(grid, row, column, i, j - 1);
    }
}
