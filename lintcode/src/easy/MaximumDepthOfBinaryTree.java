package easy;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/5 9:30.
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example
 * Given a binary tree as follow:
 *
 *      1
 *     / \
 *    2   3
 *       / \
 *      4   5
 *
 * The maximum depth is 3.
 *
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode root, int depth) {
        if(root == null) return depth;
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }

}
