package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: decaywood
 * @date: 2015/10/17 19:33.
 *
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.
 *
 * Example
 * Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Challenge
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 */
public class MinimumSizeSubarraySum {

    public int minimumSize(int[] nums, int s) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length || sum >= s;) {
            if (sum < s && i < nums.length) {
                int num = nums[i++];
                sum += num;
                queue.offer(num);
                continue;
            }
            minLength = Math.min(minLength, queue.size());
            sum -= queue.poll();
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minimumSize(new int[]{2, 5}, 7));
    }

}
