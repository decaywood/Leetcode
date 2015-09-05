package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/3 13:56.
 *
 * Find the nth to last element of a singly linked list.
 *
 * The minimum number of nodes in list is n.
 *
 * Example
 * Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
 *
 */
public class NthToLastNodeInList {

    static ListNode nthToLast(ListNode head, int n) {
        if(head == null) return null;
        ListNode node = head;
        int count = 0;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        while (count >= n) {
            head = head.next;
            count--;
        }
        return head;
    }



}
