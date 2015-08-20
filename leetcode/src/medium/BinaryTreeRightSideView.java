package medium;

import dataStructure.TreeNode;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/7/26 14:36
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 *  2    3         <---
 *  \     \
 *  5      4       <---
 * You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {

    private final static TreeNode START = new TreeNode(Integer.MAX_VALUE);
    private final static TreeNode END = new TreeNode(Integer.MIN_VALUE);
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        deque.offer(START);
        deque.offer(root);
        deque.offer(END);
        rightSideView(list, deque);
        return list;
    }


    public static void rightSideView(List<Integer> list, Deque<TreeNode> queue) {
        boolean isSideViewNext = false;
        while (true) {
            TreeNode node = queue.poll();
            if (isSideViewNext) {
                list.add(node.val);
                queue.offer(START);
                isSideViewNext = false;
            }
            if (node == START) isSideViewNext = true;

            if(node.right != null) queue.offer(node.right);
            if(node.left != null) queue.offer(node.left);
            if (node == END) break;
        }
        queue.offer(END);
        if(queue.size() > 2) rightSideView(list, queue);

    }



}
