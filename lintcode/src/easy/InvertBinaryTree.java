package easy;

import dataStructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/8/22 20:49.
 *
 * Invert a binary tree.
 *
 * Example
 *   1         1
 *  / \       / \
 * 2   3  => 3   2
 *    /       \
 *   4         4
 * Challenge
 * Do it in recursion is acceptable, can you do it without recursion?
 */
public class InvertBinaryTree {

/* version recursion

    public void invertBinaryTree(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertBinaryTree(right);
        invertBinaryTree(left);
    }
*/

    public void invertBinaryTree(TreeNode root) {
        if(root == null) return;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if(left != null) queue.offer(left);
            if(right != null) queue.offer(right);
        }
    }


}
