package medium;

import dataStructure.ListNode;

import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/9/3 15:28.
 *
 *
 * Reverse a linked list from position m to n.
 *
 * Example
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 *
 * Note
 * Given m, n satisfy the following condition: 1 ¡Ü m ¡Ü n ¡Ü length of list.
 *
 * Challenge
 * Reverse it in-place and in one-pass
 *
 */
public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int m , int n) {
        if(head == null) return null;
        ListNode node = new ListNode(0);
        ListNode res = node;
        node.next = head;
        LinkedList<ListNode> deque = new LinkedList<>();
        ListNode cut1 = node;
        ListNode cut2 = node;
        int count = 0;
        while (count <= n) {
            ListNode temp = node.next;
            if (count == m - 1) cut1 = node;
            else if (count == m) {
                deque.addLast(node);
                cut2 = node;
            } else if (count > m && count <= n) {
                deque.addLast(node.next);
                node.next = deque.pollFirst();
                deque.addFirst(node);
            }
            node = temp;
            count++;
        }
        cut1.next = deque.pollFirst();
        cut2.next = deque.isEmpty() ? null : deque.pollLast();
        return res.next;
    }




}
