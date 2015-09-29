package hard;

/**
 * @author: decaywood
 * @date: 2015/9/28 20:51
 *
 * Follow up for N-Queens problem.
 * @see NQueens
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 */
public class NQueensII {

    public int totalNQueens(int n) {
        int[] queensPos = new int[n];
        int[] count = new int[1];
        solveNQueens(count, queensPos, 0);
        return count[0];
    }

    public void solveNQueens(int[] count, int[] queensPos, int level) {
        if(level == queensPos.length) count[0]++;
        for (int i = 0; i < queensPos.length; i++) {
            if(canPlace(queensPos, level, i)) {
                queensPos[level] = i;
                solveNQueens(count, queensPos, level + 1);
            }
        }
    }

    public boolean canPlace(int[] queensPos, int level, int place) {
        for (int i = 0; i < level; i++) if(place == queensPos[i] || Math.abs(level - i) == Math.abs(place - queensPos[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(8));
    }
}
