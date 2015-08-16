package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/8/15 11:23
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 */
public class PartitionList {


    public static ListNode partition(ListNode head, int x) {
        ListNode bigNode = new ListNode(0);
        ListNode bigHead = bigNode;
        ListNode smallNode = new ListNode(0);
        ListNode smallHead = smallNode;
        while(head != null)
        {
            if(head.val < x) {
                smallNode.next = head;
                smallNode = smallNode.next;
            } else {
                bigNode.next = head;
                bigNode = bigNode.next;
            }
            head = head.next;
        }
        bigNode.next = null;
        smallNode.next = null;
        bigHead = bigHead.next;
        smallNode.next = bigHead;
        smallHead = smallHead.next;
        return smallHead;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,4,3,2,5,2};
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int x : ints) {
            node.next = new ListNode(0);
            node.next.val = x;
            node = node.next;
        }
        head = head.next;
        ListNode result = partition(head, 3);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

}
