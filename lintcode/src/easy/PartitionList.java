package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/2 12:34.
 *
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
 *
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode greaterEqual = new ListNode(0);
        ListNode smaller = new ListNode(0);
        partition(head, greaterEqual, smaller, x);
    }

    public ListNode partition(ListNode head, ListNode greaterEqual, ListNode smaller, int x) {

    }
}
