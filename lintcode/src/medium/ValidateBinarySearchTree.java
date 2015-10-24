package medium;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/5 10:46.
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example
 * An example:
 *
 *       2
 *      / \
 *     1   3
 *        /
 *       4
 *        \
 *         5
 *
 * The above binary tree is serialized as {2,1,3,#,#,4,#,#,5} (in level order).
 *
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return root == null || root.left == null && root.right == null || isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int left, int right) {
        if(root == null) return true;
        boolean res = root.val > left && root.val < right;
        return res && isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
    }


}
