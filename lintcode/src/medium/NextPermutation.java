package medium;

/**
 * @author: decaywood
 * @date: 2015/9/1 19:30.
 *
 * Given a list of integers, which denote a permutation.
 *
 * Find the next permutation in ascending order.
 *
 * Example
 * For [1,3,2,3], the next permutation is [1,3,3,2]
 *
 * For [4,3,2,1], the next permutation is [1,2,3,4]
 *
 * Note
 * The list may contains duplicate integers.
 *
 * 思路：题意寻找比当前排列顺序大的下一个排列。
 *
 * 对当前排列从后向前扫描，找到一对为升序的相邻元素，记为 i 和 i+1。
 *
 * 如果不存在这样一对为升序的相邻元素，则所有排列均已找到，算法结束；
 *
 * 否则，重新对当前排列从后向前扫描，找到第一个大于i的元素k，交换i和k，
 *
 * 然后对从i + 1开始到结束的子序列反转，则此时得到的新排列就为下一个字典序排列。
 *
 */
public class NextPermutation {

    public static int[] nextPermutation(int[] nums) {
        if (nums.length < 2) return nums;
        int i, k;
        for (i = nums.length - 2; i >= 0; i--) if (nums[i] < nums[i+1]) break;
        for (k = nums.length - 1; k > i && i >= 0; k--) if (nums[i] < nums[k]) break;
        if (i >= 0) swap(nums, i, k);
        reverse(nums, i + 1, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
        return nums;
    }

    private static void swap(int[] arr, int x, int y) {
        arr[x] ^= arr[y];
        arr[y] ^= arr[x];
        arr[x] ^= arr[y];
    }

    private static void reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            swap(arr, begin, end);
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1,2,1});
    }
}
