package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/28 18:30
 *
 * The n-queens puzzle is the problem of placing n queens on an n¡Án
 * chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queensPos = new int[n];
        solveNQueens(res, queensPos, 0);
        return res;
    }

    public void solveNQueens(List<List<String>> res, int[] queensPos, int level) {
        if(level == queensPos.length) {
            buildAnswer(res, queensPos);
            return;
        }
        for (int i = 0; i < queensPos.length; i++) {
            if(canPlace(queensPos, level, i)) {
                queensPos[level] = i;
                solveNQueens(res, queensPos, level + 1);
            }
        }
    }

    public boolean canPlace(int[] queensPos, int level, int place) {
        for (int i = 0; i < level; i++) if(place == queensPos[i] || Math.abs(level - i) == Math.abs(place - queensPos[i])) return false;
        return true;
    }

    public void buildAnswer(List<List<String>> res, int[] queensPos) {
        StringBuilder builder = new StringBuilder();
        for (int ignored : queensPos) builder.append('.');
        List<String> list = new ArrayList<>();
        for (int position : queensPos) {
            builder.setCharAt(position, 'Q');
            list.add(builder.toString());
            builder.setCharAt(position, '.');
        }
        res.add(list);
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(8);
    }
}