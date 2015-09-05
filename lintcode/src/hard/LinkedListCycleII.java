package hard;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/3 16:45.
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Example
 * Given -21->10->4->5, tail connects to node index 1£¬·µ»Ø10
 *
 * Challenge
 * Follow up:
 * Can you solve it without using extra space?
 *
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

}
