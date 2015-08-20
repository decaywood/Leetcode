package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/8/20 20:09
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElement {

    public ListNode removeElements(ListNode head, int val) {
        ListNode nodeHead = new ListNode(0);
        nodeHead.next = head;
        ListNode previous = nodeHead;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
                current = current.next;
            } else {
                previous = previous.next;
                current = current.next;
            }
        }
        return nodeHead.next;
    }

}
