package easy;

import dataStructure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/10/21 23:17.
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Challenge
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        Deque<ListNode> deque = new LinkedList<>();
        deque.offerLast(dummyNode);
        while (head != null || deque.size() == 3) {
            if (deque.size() == 3) {
                ListNode h = deque.pollFirst();
                ListNode next = deque.peekFirst();
                deque.peekFirst().next = deque.peekLast().next;
                deque.peekLast().next = deque.pollFirst();
                h.next = deque.pollLast();
                deque.offerLast(next);
                continue;
            }
            if(head != null) deque.offerLast(head);
            head = head == null ? null : head.next;
        }
        if (deque.size() == 2) deque.peekFirst().next = deque.peekLast();
        return dummyNode.next;
    }


}
