package leetcode.hard;

/**
 * 2014年11月13日
 * 
 * @author decaywood
 * 
 * 
 *         Suppose a sorted array is rotated at some pivot unknown to you
 *         beforehand.
 * 
 *         (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 *         Find the minimum element.
 * 
 *         The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] num) {
        int min = num[0];
        for (int i = 0; i < num.length - 1; i++) {
            int current = num[i];
            int next = num[i + 1];
            if (current <= next) {
                min = Math.min(current, min);
            } else {
                min = next;
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        new FindMinimumInRotatedSortedArrayII().findMin(new int[] { 1, 3, 3 });
    }
}
