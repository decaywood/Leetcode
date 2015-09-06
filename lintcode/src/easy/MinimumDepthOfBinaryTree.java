package easy;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/6 10:32
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.
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
 * The minimum depth is 2
 *
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return minDepth(root, 1);
    }

    public int minDepth(TreeNode root,  int depth) {
        if(root.left == null && root.right == null) return depth;
        int dep = Integer.MAX_VALUE;
        if(root.left != null) dep = Math.min(dep, minDepth(root.left, depth + 1));
        if(root.right != null) dep = Math.min(dep, minDepth(root.right, depth + 1));
        return dep;
    }


}
