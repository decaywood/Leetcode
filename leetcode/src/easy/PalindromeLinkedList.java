package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/7/19 15:24
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 */
public class PalindromeLinkedList {



    public static boolean isPalindrome(ListNode head) {

        ListNode step = head;
        ListNode doubleStep = head;
        while (doubleStep != null && doubleStep.next != null) {
            step = step.next;
            doubleStep = doubleStep.next.next;
        }
        ListNode tail = reverseNode(step);
        while (tail != null) {
            if(tail.val != head.val) return false;
            tail = tail.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode reverseNode(ListNode head) {
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

    public static void main(String[] args) {
        int[] s = new int[]{-31900, 22571, -31634, 19735, 13748, 16612, -28299, -16628, 9614, -14444, -14444, 9614, -16628, -31900, 16612, 13748, 19735, -31634, 22571, -28299};
        ListNode node = new ListNode();
        ListNode head = node;
        for (int i = 0; i < s.length; i++) {
            node.next = new ListNode();
            node = node.next;
            node.val = s[i];
        }
        head = head.next;
        System.out.println(isPalindrome(head));
    }



}
