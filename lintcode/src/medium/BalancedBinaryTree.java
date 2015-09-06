package medium;

import dataStructure.TreeNode;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author: decaywood
 * @date: 2015/9/5 11:27.
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined
 * as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example
 * Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
 *
 *  A)  3            B)    3
 *     / \                  \
 *    9  20                 20
 *      /  \                / \
 *     15   7              15  7
 *
 * The binary tree A is a height-balanced binary tree, but B is not.
 *
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        boolean[] isBalanced = new boolean[]{true};
        maxTreeDepth(root, isBalanced, 0);
        return isBalanced[0];
    }


    public int maxTreeDepth(TreeNode root, boolean[] isBalanced, int depth) {
        if(root == null) return depth;
        int left = maxTreeDepth(root.left, isBalanced, depth + 1);
        int right = maxTreeDepth(root.right, isBalanced, depth + 1);
        isBalanced[0] = isBalanced[0] && Math.abs(left - right) <= 1;
        return Math.max(left, right);
    }


}
