package hard;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author: decaywood
 * @date: 2015/7/19 9:55
 *
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3 5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 * Note:
 * You may assume k is always valid, ie: 1 �� k �� input array's size for non-empty array
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0) return nums;

        int[] arr = IntStream.range(0, nums.length - k + 1).map(i ->
            Arrays.stream(Arrays.copyOfRange(nums, i, i + k)).reduce(Integer.MIN_VALUE, Math::max)
        ).toArray();

        return arr;
    }

}
