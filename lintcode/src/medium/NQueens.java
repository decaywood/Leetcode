package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/7 12:23
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *
 * [".Q..", // Solution 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 * ["..Q.", // Solution 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 *
 * Challenge
 * Can you do it without recursion?
 *
 */
public class NQueens {

    /**
     *
     * 把棋盘存储为一个N维数组a[N]，数组中第i个元素的值代表第i行的皇后位置，
     * 这样便可以把问题的空间规模压缩为一维O(N)，在判断是否冲突时也很简单，首先每行只有一个皇后，
     * 且在数组中只占据一个元素的位置，行冲突就不存在了，其次是列冲突，判断一下是否有a[i]与当前要放置皇后的列j相等即可。
     * 至于斜线冲突，通过观察可以发现所有在斜线上冲突的皇后的位置都有规律即它们所在的行列互减的绝对值相等，
     * 即| row – i | = | col – a[i] | 。这样某个位置是否可以放置皇后的问题已经解决。
     *
     * 伪代码：
     *
     *    void queen(int row){
     *        if (n == row)      //如果已经找到结果，则打印结果
     *           print_result();
     *        else {
     *           for (k=0 to N) { //试探第row行每一个列
     *               if (can_place(row, k) {
     *                   place(row, k);   //放置皇后
     *                   queen(row + 1);  //继续探测下一行
     *               } else {
     *                   清空当前行棋盘，回溯
     *               }
     *           }
     *        }
     *    }
     *
     */

    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        int[] chessboard = new int[n];
        Arrays.fill(chessboard, Integer.MAX_VALUE);
        queen(res, chessboard, 0, n);
        return res;
    }


    private void queen(List<ArrayList<String>> res, int[] chessboard, int row, int n) {
        if(row == n) {
            res.add(getResult(chessboard));
            Arrays.fill(chessboard, row - 1, chessboard.length, Integer.MAX_VALUE);
            return;
        }
        for (int column = 0; column < n; column++) {
            if(!canPlace(chessboard, row, column)) {
                if(column + 1 == n) Arrays.fill(chessboard, row - 1, chessboard.length, Integer.MAX_VALUE);
                continue;
            }
            chessboard[row] = column;
            queen(res, chessboard, row + 1, n);
        }
    }

    private boolean canPlace(int[] chessboard, int placeRow, int placeColumn) {
        for (int row = 0; row < chessboard.length; row++) {
            int column = chessboard[row];
            boolean diagonalConflict = Math.abs(placeColumn - column) == Math.abs(placeRow - row);
            if(diagonalConflict || placeColumn == column) return false;
        }
        return true;
    }

    private ArrayList<String> getResult(int[] chessboard) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int ignored : chessboard) builder.append('.');
        for (int index : chessboard) {
            builder.setCharAt(index, 'Q');
            res.add(builder.toString());
            builder.setCharAt(index, '.');
        }
        return res;
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(8);
    }
}
