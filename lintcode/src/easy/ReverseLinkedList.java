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

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reverse(head);
    }

}
