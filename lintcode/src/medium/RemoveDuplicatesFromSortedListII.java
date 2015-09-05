package medium;

import dataStructure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/9/3 14:32.
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example
 *
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 */
public class RemoveDuplicatesFromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(Integer.MAX_VALUE);
        node.next = head;
        Deque<ListNode> deque = new LinkedList<>();
        deque.addLast(node);
        while (head != null) {
            if(deque.size() == 1 && deque.peek().val != head.val) deque.addLast(head);
            else if(deque.size() == 2 && deque.peekLast().val != head.val) {
                deque.pollFirst();
                deque.addLast(head);
            } else {
                while (head != null && deque.peekLast().val == head.val) head = head.next;
                deque.pollLast();
                deque.peekLast().next = head;
                if(head == null) break;
                deque.addLast(head);
            }
            head = head.next;
        }
        return node.next;
    }



}
