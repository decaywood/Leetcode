package easy;

import dataStructure.TreeNode;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/9/5 10:14.
 * <p>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * Given binary tree {1,#,2,3}:
 * <p>
 *      1
 *       \
 *        2
 *       /
 *      3
 * return [1,2,3].
 * <p>
 * Challenge
 * Can you do it without recursion?
 *
 */
public class BinaryTreePreorderTraversal {

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque< TreeNode > stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return list;
    }



}
