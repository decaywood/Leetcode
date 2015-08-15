package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/8/15 11:17
 */
public class ReverseLinkedList {



    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node1 = head;
        ListNode node2 = node1.next;
        ListNode temp = node2.next;
        node1.next = null;
        if(temp == null) {
            node2.next = node1;
            return node2;
        }
        while (node2 != null) {
            temp = node2.next;
            node2.next = node1;
            if(temp == null) return node2;
            node1 = temp;
            temp = node2;
            node2 = node1.next;
            node1.next = temp;
        }
        return node1;
    }


}
