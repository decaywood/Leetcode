package medium;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/28 9:30
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long lower, long upper) {
        return root == null || root.val > lower && root.val < upper && isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

}
