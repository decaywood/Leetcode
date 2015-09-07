package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/7 12:23
 *
 * The n-queens puzzle is the problem of placing n queens on an n��n chessboard
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
     * �����̴洢Ϊһ��Nά����a[N]�������е�i��Ԫ�ص�ֵ�����i�еĻʺ�λ�ã�
     * ��������԰�����Ŀռ��ģѹ��ΪһάO(N)�����ж��Ƿ��ͻʱҲ�ܼ򵥣�����ÿ��ֻ��һ���ʺ�
     * ����������ֻռ��һ��Ԫ�ص�λ�ã��г�ͻ�Ͳ������ˣ�������г�ͻ���ж�һ���Ƿ���a[i]�뵱ǰҪ���ûʺ����j��ȼ��ɡ�
     * ����б�߳�ͻ��ͨ���۲���Է���������б���ϳ�ͻ�Ļʺ��λ�ö��й��ɼ��������ڵ����л����ľ���ֵ��ȣ�
     * ��| row �C i | = | col �C a[i] | ������ĳ��λ���Ƿ���Է��ûʺ�������Ѿ������
     *
     * α���룺
     *
     *    void queen(int row){
     *        if (n == row)      //����Ѿ��ҵ���������ӡ���
     *           print_result();
     *        else {
     *           for (k=0 to N) { //��̽��row��ÿһ����
     *               if (can_place(row, k) {
     *                   place(row, k);   //���ûʺ�
     *                   queen(row + 1);  //����̽����һ��
     *               } else {
     *                   ��յ�ǰ�����̣�����
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
