package medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author: decaywood
 * @date: 2015/8/22 20:31.
 *
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 *
 * Example
 * Given N = 3 and the array [0, 1, 3], return 2.
 *
 * Challenge
 * Do it in-place with O(1) extra memory and O(n) time.
 *
 */
public class FindTheMissingNumber {

//    public static int findMissing(int[] nums) {
//        int sum = IntStream.range(0, nums.length + 2).reduce(0, Integer::sum);
//        return IntStream.of(nums).reduce(sum, (x, y) -> x - y);
//    }

    public static int findMissing(int[] nums) {
        int sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum += i;
            if(i < nums.length) sum -= nums[i];
        }
        return sum;
    }
}
