package medium;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: decaywood
 * @date: 2015/9/5 14:46.
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * Example
 * Given binary tree {3,9,20,#,#,15,7},
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *
 *
 * return its level order traversal as:
 *
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 * Challenge
 * Using only 1 queue to implement it.
 *
 */
public class BinaryTreeLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode dummyNode = new TreeNode(Integer.MAX_VALUE);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(dummyNode);
        ArrayList<Integer> list = new ArrayList<>();
        while (queue.size() > 1) {
            TreeNode node = queue.poll();
            if (node.val == Integer.MAX_VALUE) {
                res.add(list);
                list = new ArrayList<>();
                queue.offer(dummyNode);
                continue;
            }
            list.add(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        res.add(list);
        return res;
    }

}
