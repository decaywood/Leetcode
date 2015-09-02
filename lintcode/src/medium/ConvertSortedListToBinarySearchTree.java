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
        TreeNode node = buildTree(head, right);
        return node;
    }

    public static TreeNode buildTree(ListNode leftNode, ListNode rightNode) {
        ListNode midPre = findMid(leftNode, rightNode);
        if (midPre == null) {
            TreeNode node = new TreeNode(leftNode.val);
            node.right = new TreeNode(rightNode.val);
            return node;
        }
        ListNode mid = midPre.next;
        TreeNode node = new TreeNode(mid.val);
        node.left = leftNode == midPre ? new TreeNode(midPre.val) : buildTree(leftNode, midPre);
        node.right = rightNode == mid.next ? new TreeNode(mid.next.val) : buildTree(mid.next, rightNode);
        return node;
    }

    private static ListNode findMid(ListNode leftNode, ListNode rightNode) {
        ListNode doubleNode = leftNode;
        ListNode previous = null;
        while (doubleNode != rightNode && doubleNode.next != rightNode) {
            previous = leftNode;
            leftNode = leftNode.next;
            doubleNode = doubleNode.next.next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        sortedListToBST(head);
    }

}
