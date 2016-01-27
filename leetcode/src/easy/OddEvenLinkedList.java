package easy;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2016/1/26 20:20
 * <p>
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode tmpOdd = head;
        ListNode tmpEven = head.next;
        ListNode Even = tmpEven;
        ListNode current = tmpEven.next;
        boolean isOdd = true;
        while (current != null) {
            if (isOdd) {
                tmpOdd.next = current;
                tmpOdd = current;
            } else {
                tmpEven.next = current;
                tmpEven = current;
            }
            current = current.next;
            isOdd = !isOdd;
        }
        tmpEven.next = null;
        tmpOdd.next = Even;
        return head;
    }

    public static void main(String[] args) {
        new OddEvenLinkedList().oddEvenList(ListNode.generateTestCase(1, 2, 3, 4, 5, 6, 7, 8));
    }

}
