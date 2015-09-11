package medium;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2015/9/11 9:54
 *
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 * Example
 * For n=4, there are 2 distinct solutions.
 *
 */
public class NQueensII {

    public int totalNQueens(int n) {
        int[] chessboard = new int[n];
        Arrays.fill(chessboard, Integer.MAX_VALUE);
        return queen(chessboard, 0, n);
    }


    private int queen(int[] chessboard, int row, int n) {
        if(row == n) {
            Arrays.fill(chessboard, row - 1, chessboard.length, Integer.MAX_VALUE);
            return 1;
        }
        int sum = 0;
        for (int column = 0; column < n; column++) {
            if(!canPlace(chessboard, row, column)) {
                if(column + 1 == n) Arrays.fill(chessboard, row - 1, chessboard.length, Integer.MAX_VALUE);
                continue;
            }
            chessboard[row] = column;
            sum += queen(chessboard, row + 1, n);
        }
        return sum;
    }

    private boolean canPlace(int[] chessboard, int placeRow, int placeColumn) {
        for (int row = 0; row < chessboard.length; row++) {
            int column = chessboard[row];
            boolean diagonalConflict = Math.abs(placeColumn - column) == Math.abs(placeRow - row);
            if(diagonalConflict || placeColumn == column) return false;
        }
        return true;
    }



}
