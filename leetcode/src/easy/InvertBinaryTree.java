package easy;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/8/7 10:30
 *
 *
 * Invert a binary tree.
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 */
public class InvertBinaryTree {



    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        doInvertTree(root);
        return root;
    }

    public void doInvertTree(TreeNode root) {
        TreeNode tempRight;
        TreeNode tempLeft;

        tempRight = root.right;
        tempLeft = root.left;

        root.left = tempRight;
        root.right = tempLeft;

        if(root.left != null) invertTree(root.left);
        if(root.right != null) invertTree(root.right);
    }

}
