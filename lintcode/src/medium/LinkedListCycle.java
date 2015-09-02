package medium;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/2 20:45.
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Example
 * Given -21->10->4->5, tail connects to node index 1, return true
 *
 * Challenge
 * Follow up:
 * Can you solve it without using extra space?
 *
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

}
