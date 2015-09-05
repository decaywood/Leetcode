package easy;

/**
 * @author: decaywood
 * @date: 2015/8/26 16:44
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 *
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Have you met this question in a real interview? Yes
 * Example
 * Consider the following matrix:
 *
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 *
 * Challenge
 * O(log(n) + log(m)) time
 *
 */
public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int left = 0;
        int right = matrix.length - 1;
        int index = 0;
        while (left < right) {
            int middle = (left + right) / 2;
            if(left + 1 == right || left + 2 == right)
                index = matrix[right][0] > target ? matrix[middle][0] > target ? left : middle : right;
            int num = matrix[middle][0];
            left = num < target ? middle + 1 : left;
            right = num < target ? right : middle - 1;
        }
        left = 0;
        right = matrix[index].length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            int num = matrix[index][middle];
            if(num == target || matrix[index][left] == target || matrix[index][right] == target) return true;
            left = num < target ? middle + 1 : left;
            right = num < target ? right : middle - 1;
        }
        return false;
    }


}
