package hard;

import dataStructure.ListNode;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/10/13 20:42
 *
 * Numbers keep coming, return the median of numbers at every time a new number added.
 *
 * Example
 * For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
 *
 * For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
 *
 * For numbers coming list: [2, 20, 100], return [2, 2, 20].
 *
 * Challenge
 * Total run time in O(nlogn).
 *
 * Clarification
 * What's the definition of Median? - Median is the number that in the middle of a sorted array.
 * If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3],
 * median is 2. If A=[1,19], median is 1.
 *
 */
public class DataStreamMedian {


    /**
     * O(n^2)
     */
    public int[] medianII(int[] nums) {
        ListNode min = new ListNode(Integer.MIN_VALUE);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ListNode temp = min;
            while (temp.next != null && temp.next.val < num) temp = temp.next;
            ListNode node = new ListNode(num);
            node.next = temp.next;
            temp.next = node;
            temp = min;
            int count = (i >> 1) + 1;
            while (count-- > 0) temp = temp.next;
            res[i] = temp.val;
        }
        return res;
    }

    public static void main(String[] args) {
        new DataStreamMedian().medianII(new int[]{1});
    }

}
