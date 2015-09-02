package medium;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/9/2 15:03
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example
 * Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
 *
 * 思路：先将链表形成闭环，向前移动k步本质上就是在 相对原本的head往后n - k个节点拆环
 *
 */
public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int count = 0;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        k = k % (count + 1);
        node.next = head; // 形成闭环
        node = head;
        while (count-- != k) node = node.next;
        head = node.next;
        node.next = null; //拆环
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotateRight(head, 2512);
    }
}
