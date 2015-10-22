package medium;

import dataStructure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/10/21 23:41.
 *
 * Implement a function to check if a linked list is a palindrome.
 *
 * Example
 * Given 1->2->1, return true
 *
 * Challenge
 * Could you do it in O(n) time and O(1) space?
 *
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        count /= 2;
        temp = head;
        while (count-- != 0) temp = temp.next;
        temp = reverse(temp);
        while (head != null && temp != null) {
            if(head.val != temp.val) return false;
            head = head.next;
            temp = temp.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode point = node;
        node = node.next;
        point.next = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = point;
            point = node;
            node = next;
        }
        return point;
    }



}
