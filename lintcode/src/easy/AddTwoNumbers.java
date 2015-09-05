package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/3 13:39.
 *
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 *
 * Example
 * Given 7->1->6 + 5->9->2. That is, 617 + 295.
 *
 * Return 2->1->9. That is 912.
 *
 * Given 3->1->5 and 5->9->2, return 8->0->8.
 *
 */
public class AddTwoNumbers {

    public static ListNode addLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        int carryBit = 0;
        while (l1 != null || l2 != null) {
            int num = carryBit + (l1 == null ? l2.val : l2 == null ? l1.val : l1.val + l2.val);
            int cur = num % 10;
            carryBit = num / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carryBit != 0) head.next = new ListNode(carryBit); // 最后一位进位
        return res.next;
    }


}
