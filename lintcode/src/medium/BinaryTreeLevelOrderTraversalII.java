package medium;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/9/6 15:51
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
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
 * return its bottom-up level order traversal as:
 *
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 *
 */
public class BinaryTreeLevelOrderTraversalII {


    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode dummyNode = new TreeNode(Integer.MAX_VALUE);
        deque.offer(root);
        deque.offer(dummyNode);
        ArrayList<Integer> list = new ArrayList<>();
        while (deque.size() > 1) {
            TreeNode node = deque.poll();
            if (node == dummyNode) {
                res.add(list);
                list = new ArrayList<>();
                deque.offer(dummyNode);
                continue;
            }
            list.add(node.val);
            if(node.left != null) deque.offer(node.left);
            if(node.right != null) deque.offer(node.right);
        }
        res.add(list);
        for (int i = 0, j = res.size() - 1;i < j; i++, j--) {
            ArrayList<Integer> temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
        }
        return res;
    }

}
