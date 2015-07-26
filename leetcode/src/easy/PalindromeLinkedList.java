package easy;

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

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode next(ListNode next) {
            this.next = next;
            return this;
        }
    }


    public boolean isPalindrome(ListNode head) {

        if(head == null) return true;
        if(head.next == null) return true;
        if(head.next.next.next == null) return head.val == head.next.val;

        ListNode doubleSpeed = head;
        ListNode middle = head;
        while (doubleSpeed != null && doubleSpeed.next != null) {
            middle = middle.next;
            if (doubleSpeed.next.next != null) {
                doubleSpeed = doubleSpeed.next.next;
            } else {
                break;
            }
        }

        ListNode h = head;
        int value = middle.val + h.val;
        while (middle != null) {
            int v1 = middle.val;
            int v2 = h.val;
            if (value != v1 + v2) {
                return false;
            }
            middle = middle.next;
            h = h.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1).next(new ListNode(1).next(new ListNode(0).next(new ListNode(0).next(new ListNode(1)))));
        ListNode node1 = new ListNode(1).next(new ListNode(3));
//        node.next = node;
        System.out.println(new PalindromeLinkedList().isPalindrome(node));
    }



}
