package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/2 10:50.
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * Example
 * Given linked list: 1->2->3->4->5->null, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5->null.
 * Note
 * The minimum number of nodes in list is n.
 *
 * Challenge
 * O(n) time
 *
 */
public class RemoveNthNodeFromEndOfList {

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode h = head;
        int count = 0;
        while (h != null) {
            h = h.next;
            count++;
        }
        h = node;
        while (h != null) {
            if (count == n) {
                h.next = h.next.next;
                break;
            }
            h = h.next;
            count--;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        removeNthFromEnd(node, 1);
    }
}
