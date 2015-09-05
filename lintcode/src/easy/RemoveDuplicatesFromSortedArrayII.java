package easy;

/**
 * @author: decaywood
 * @date: 2015/8/25 20:02.
 *
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 *
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int startPosition = 0;
        boolean isRepeated = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[startPosition]) {
                isRepeated = false;
                startPosition++;
                nums[startPosition] = nums[i];
            } else if (!isRepeated) {
                startPosition++;
                nums[startPosition] = nums[i];
                isRepeated = true;
            }
        }
        return startPosition + 1;
    }


}
