package medium;

import dataStructure.ListNode;
import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/2 15:47
 * <
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * Example
 *                2
 * 1->2->3  =>   / \
 *              1   3
 *
 */
public class ConvertSortedListToBinarySearchTree {

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode right = head;
        while (right.next != null) right = right.next;
        TreeNode node = buildTree(null, head, right);
        return node;
    }

    public static TreeNode buildTree(ListNode parent, ListNode leftNode, ListNode rightNode) {
        ListNode mid = findMid(leftNode, rightNode);
        TreeNode node = new TreeNode(mid.val);
        node.left = leftNode.next == mid ? new TreeNode(leftNode.val) : leftNode == mid ? null : buildTree(mid, leftNode, mid);
        node.right = mid.next != rightNode ? buildTree(mid, mid.next, rightNode) : mid.next == parent ? null : new TreeNode(rightNode.val);
        return node;
    }

    private static ListNode findMid(ListNode leftNode, ListNode rightNode) {
        ListNode doubleNode = leftNode;
        while (doubleNode != rightNode && doubleNode.next != rightNode) {
            leftNode = leftNode.next;
            doubleNode = doubleNode.next.next;
        }
        return leftNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        sortedListToBST(head);
    }

}
