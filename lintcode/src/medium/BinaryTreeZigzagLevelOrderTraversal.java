package medium;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/9/6 14:48
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
 * return its zigzag level order traversal as:
 *
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        ArrayList<Integer> list = new ArrayList<>();
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
                if(pollFirst) deque.offerLast(dummyNode);
                else deque.offerFirst(dummyNode);
                continue;
            }
            list.add(node.val);
            if(pollFirst) {
                if(node.left != null) deque.offerLast(node.left);
                if( node.right != null) deque.offerLast(node.right);
            }
            else {
                if( node.right != null) deque.offerFirst(node.right);
                if(node.left != null) deque.offerFirst(node.left);
            }
        }
        res.add(list);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.generateTestCase("3,9,20,#,#,15,7");
        new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(node);
    }

}
