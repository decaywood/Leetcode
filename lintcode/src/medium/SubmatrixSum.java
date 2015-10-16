package medium;

/**
 * @author: decaywood
 * @date: 2015/10/16 10:34
 *
 * Given an integer matrix, find a submatrix where the sum of numbers is zero.
 * Your code should return the coordinate of the left-up and right-down number.
 *
 * Example
 * Given matrix
 *
 * [
 *  [1 ,5 ,7],
 *  [3 ,7 ,-8],
 *  [4 ,-8 ,9],
 * ]
 * return [(1,1), (2,2)]
 *
 * Challenge
 * O(n3) time.
 *
 */
public class SubmatrixSum {

    public int[][] submatrixSum(int[][] matrix) {
        int[][] res = new int[2][2];
        int rowLen = matrix.length;
        int colLen = matrix[matrix.length - 1].length;

        for (int i = rowLen - 2; i >= 0; i--) matrix[i][colLen - 1] += matrix[i + 1][colLen - 1];
        for (int i = colLen - 2; i >= 0; i--) matrix[rowLen - 1][i] += matrix[rowLen - 1][i + 1];

        for (int i = matrix.length - 2; i >= 0; i--)
            for (int j = matrix[i].length - 2; j >= 0; j--)
                matrix[i][j] += (matrix[i + 1][j] + matrix[i][j + 1] - matrix[i + 1][j + 1]);

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                for (int k = i; k < rowLen - 1; k++) {
                    for (int l = j; l < colLen - 1; l++) {
                        if(isZero(matrix[i][j], res, i, j, rowLen - 1, colLen - 1)) return res;
                        int sum = matrix[i][j] - matrix[i][l + 1] - matrix[k + 1][j] + matrix[k + 1][l + 1];
                        if (isZero(sum, res, i, j, k, l)) return res;
                    }
                }
            }
        }

        for (int i = 0; i < colLen; i++)
            for (int j = i; j < colLen - 1; j++){
                int sum = matrix[0][i] - matrix[0][j + 1];
                if (isZero(sum, res, 0, i, 0, j)) return res;
            }

        for (int i = 0; i < rowLen; i++)
            for (int j = i; j < rowLen - 1; j++){
                int sum = matrix[i][0] - matrix[j + 1][0];
                if (isZero(sum, res, i, 0, j, 0)) return res;
            }

        return res;
    }



    private boolean isZero(int sum,int[][] res, int i, int j, int k, int l) {
        if (sum == 0) {
            res[0][0] = i;
            res[0][1] = j;
            res[1][0] = k;
            res[1][1] = l;
            return true;
        }
        return false;
    }

}
