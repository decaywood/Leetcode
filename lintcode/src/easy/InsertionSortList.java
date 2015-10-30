package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/10/30 22:02.
 *
 * Sort a linked list using insertion sort.
 *
 * Example
 * Given 1->3->2->0->null, return 0->1->2->3->null.
 *
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            insert(dummyNode, temp);
        }
        return dummyNode.next;
    }

    private void insert(ListNode head, ListNode node) {
        while (head.next != null && head.next.val < node.val) head = head.next;
        node.next = head.next;
        head.next = node;
    }


}
