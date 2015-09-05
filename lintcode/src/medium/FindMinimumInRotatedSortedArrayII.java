package medium;

/**
 * @author: decaywood
 * @date: 2015/8/28 9:57
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example
 * Given [4,4,5,6,7,0,1,2] return 0
 *
 *
 */
public class FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] num) {
        return Math.min(num[0], num[findPivot(num, 0, num.length - 1)]);
    }

    private static int findPivot(int[] num, int left, int right) {
        int mid = (left + right) / 2;
        if (left == right || left + 1 == right) {
            return right;
        }
        return num[mid] > num[right] ? findPivot(num, mid, right)
                : num[left] > num[mid] ? findPivot(num, left, mid)
                : findPivot(num, left + 1, right);
    }

}
