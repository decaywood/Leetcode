package medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/8/21 16:13
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ¡Ý s. If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 */
public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        Deque<Integer> queue = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            queue.offer(num);
            if (sum >= s){
                while (sum - queue.peek() >= s) sum -= queue.poll();
                minLength = Math.min(minLength, queue.size());
            }
        }
        return sum < s ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(5, new int[]{2,3,1,1,1,1,1}));
    }

}
