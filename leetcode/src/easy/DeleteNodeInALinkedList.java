package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/7/19 11:45
 */
public class DeleteNodeInALinkedList {


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


}
