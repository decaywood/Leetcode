package medium;

import dataStructure.ListNode;

/**
 * @author: decaywood
 * @date: 2015/10/30 21:28.
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * Example
 * The following two linked lists:
 *
 * A:          a1 → a2
 *                     ↘
 *                       c1 → c2 → c3
 *                     ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 * Note
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Challenge
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null && tempB != null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        ListNode node = tempA != null ? tempA : tempB;
        ListNode head1 = tempA != null ? headA : headB;
        ListNode head2 = tempA == null ? headA : headB;
        while (head1 != null && node != null) {
            head1 = head1.next;
            node = node.next;
        }
        while (head1 != null && head2 != null && head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == head2 ? head1 : null;
    }
}
