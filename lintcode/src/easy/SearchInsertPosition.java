package easy;

/**
 * @author: decaywood
 * @date: 2015/8/26 16:27
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume NO duplicates in the array.
 *
 * Example
 * [1,3,5,6], 5 ¡ú 2
 *
 * [1,3,5,6], 2 ¡ú 1
 *
 * [1,3,5,6], 7 ¡ú 4
 *
 * [1,3,5,6], 0 ¡ú 0
 *
 * Challenge
 * O(log(n)) time
 *
 *
 */
public class SearchInsertPosition {


    public static int searchInsert(int[] A, int target) {
        if(A.length == 0) return 0;
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            int num = A[middle];
            left = num < target ? middle + 1 : left;
            right = num < target ? right : middle - 1;
        }
        return A[left] < target ? left + 1 : left;
    }


}
