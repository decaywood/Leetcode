package easy;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/10/22 22:30.
 *
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 *
 * Here we use the right pointer in TreeNode as the next pointer in ListNode.
 *
 * Example
 *                  1
 *                   \
 *         1          2
 *        / \          \
 *       2   5    =>    3
 *      / \   \          \
 *     3   4   6          4
 *                         \
 *                          5
 *                           \
 *                            6
 * Note
 * Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.
 *
 * Challenge
 * Do it in-place without any extra memory.
 *
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if(root == null || root.left == null) {
            if(root != null && root.right != null) flatten(root.right);
            return;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        flatten(right);
        if(root.left.left == null && root.left.right == null) {
            root.right = left;
            root.left = null;
            left.right = right;
            return;
        }
        flatten(left);
        root.right = left;
        root.left = null;
        getTail(left).right = right;
    }

    public TreeNode getTail(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }

}
