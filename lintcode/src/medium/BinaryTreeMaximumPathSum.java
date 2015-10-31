package medium;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/10/31 13:10.
 *
 * Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given the below binary tree:
 *
 *      1
 *     / \
 *    2   3
 *
 * return 6.
 *
 */
public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        doMaxPathSum(root);
        return max;
    }
    public int doMaxPathSum(TreeNode root) {
        if(root == null) return 0;
        int left = doMaxPathSum(root.left);
        int right = doMaxPathSum(root.right);
        int m = Math.max(left, Math.max(right, Math.max(0, left + right)));
        max = Math.max(max, root.val + m);
        return root.val + Math.max(left, right);
    }
}
