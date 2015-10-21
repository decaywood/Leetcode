package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/10/17 20:27.
 *
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 *
 * Example
 * Given 1->2->3->4, and node 3. return 1->2->4
 *
 */
public class DeleteNodeInTheMiddleOfSinglyLinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
