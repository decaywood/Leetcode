package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/10/21 23:10.
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 *
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        ListNode temp = dummyNode;
        dummyNode.next = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return dummyNode.next;
    }


}
