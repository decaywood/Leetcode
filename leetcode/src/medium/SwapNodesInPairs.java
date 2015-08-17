package medium;

import dataStructure.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/8/17 16:08.
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 */
public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        Deque<ListNode> nodeStack = new LinkedList<>();
        ListNode result = new ListNode(0);
        nodeStack.push(result);
        while (head != null) {
            nodeStack.push(head);
            head = head.next;
            if (nodeStack.size() == 3) {
                ListNode node2 = nodeStack.pop();
                ListNode node1 = nodeStack.pop();
                ListNode headNode = nodeStack.pop();
                node2.next = node1;
                headNode.next = node2;
                nodeStack.push(node1);
            }

        }
        if (nodeStack.size() == 1) nodeStack.pop().next = null;
        else if(nodeStack.size() == 2){
            ListNode node2 = nodeStack.pop();
            ListNode node1 = nodeStack.pop();
            node1.next = node2;
            node2.next = null;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int i : new int[]{1,2,3,4,5,6}) {
            node.next = new ListNode(0);
            node.next.val = i;
            node = node.next;
        }
        swapPairs(head.next);
    }

}
