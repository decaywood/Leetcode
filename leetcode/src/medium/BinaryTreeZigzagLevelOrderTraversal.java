package medium;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/30 16:27
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *      3
 *     / \
 *    9  20
 *   / \
 *  15  7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root)  {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode dummyNode = new TreeNode(Integer.MAX_VALUE);
        deque.offerLast(root);
        deque.offerLast(dummyNode);
        boolean pollFirst = true;
        while (deque.size() > 1) {
            TreeNode node = pollFirst ? deque.pollFirst() : deque.pollLast();
            if (node.val == Integer.MAX_VALUE) {
                res.add(list);
                list = new ArrayList<>();
                pollFirst = !pollFirst;
                if (pollFirst) deque.offerLast(dummyNode);
                else deque.offerFirst(dummyNode);
                continue;
            }
            list.add(node.val);
            if (pollFirst) {
                if (node.left != null) deque.offerLast(node.left);
                if (node.right != null) deque.offerLast(node.right);
            } else {
                if (node.right != null) deque.offerFirst(node.right);
                if (node.left != null) deque.offerFirst(node.left);
            }
        }
        res.add(list);
        return res;
    }

}
