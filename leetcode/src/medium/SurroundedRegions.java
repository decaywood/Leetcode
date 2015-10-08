package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: decaywood
 * @date: 2015/9/30 13:58
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '+') continue;
                isSurrounded(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '+') board[i][j] = 'O';
            }
        }
    }

    private boolean isSurrounded(char[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> fill = new LinkedList<>();
        boolean isSurrounded = true;
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            x = arr[0];
            y = arr[1];

            if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
                if(board[x][y] != 'X') {
                    board[x][y] = 'X';
                    fill.offer(arr);
                    isSurrounded &= false;
                }
                continue;
            }
            if (board[x][y] == 'O') {
                board[x][y] = 'X';
                fill.offer(arr);
                queue.offer(new int[]{x + 1, y});
                queue.offer(new int[]{x - 1, y});
                queue.offer(new int[]{x, y + 1});
                queue.offer(new int[]{x, y - 1});
            }
        }
        if(!isSurrounded) while (!fill.isEmpty()) {
            int[] fillXY = fill.poll();
            board[fillXY[0]][fillXY[1]] = '+';
        }
        return isSurrounded;
    }
}
