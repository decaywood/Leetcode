package medium;

/**
 * @author: decaywood
 * @date: 2015/8/27 11:32
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * Example
 * Given [4, 5, 6, 7, 0, 1, 2] return 0
 *
 * Note
 * You may assume no duplicate exists in the array.
 *
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] num) {
        int index = 0;
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] > num[i + 1]) index = i + 1;
        }
        return num.length > 0 ? Math.min(num[0], num[index]) : 0;
    }

}
