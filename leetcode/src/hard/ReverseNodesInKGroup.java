package hard;

import dataStructure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/9/29 20:09
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        int len = 0;
        ListNode res = new ListNode(0);
        for (ListNode temp = head; temp != null; temp = temp.next, len++);
        Deque<ListNode> deque = new LinkedList<>();
        deque.offer(res);
        ListNode p1 = head, p2 = head.next;
        for (int i = 1; i * k <= len; i++) {
            for (int j = 1; j < k; j++) {
                if(j == 1)
                    deque.offer(p1);
                if(j == k - 1)
                    deque.poll().next = p2;
                ListNode temp = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = temp;
            }
            p1 = p2;
            p2 = p2 == null ? null : p2.next;
        }
        deque.poll().next = p1;
        return res.next;
    }


    public static void main(String[] args) {
        ListNode listNode = ListNode.generateTestCase(1,2,3,4,5,6,7);
        ListNode node = new ReverseNodesInKGroup().reverseKGroup(listNode, 4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
