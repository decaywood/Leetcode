package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/2 14:44
 *
 * Example
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 *
 * Challenge
 * Reverse it in-place and in one-pass
 *
 */
public class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode node = new ListNode(0);
        ListNode next = head;
        node.next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = node;
            node = next;
            next = temp;
        }
        head.next = null;
        return node;
    }


}
