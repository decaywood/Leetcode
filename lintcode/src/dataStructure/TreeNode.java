package dataStructure; /**
 * @author: decaywood
 * @date: 2015/8/15 11:25
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary
 * tree in which the depth of the two subtrees of every node never differ by
 * more than 1.
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    private TreeNode() { val = Integer.MAX_VALUE; }
    public TreeNode(int x) { val = x; }

    public static TreeNode generateTestCase(String testcase) {
        int[] arr = Stream.of(testcase.split(",")).mapToInt(str -> str.equals("#") ? Integer.MIN_VALUE : Integer.parseInt(str)).toArray();
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int val : arr) {
            TreeNode node = queue.poll();
            if (val == Integer.MIN_VALUE) continue;
            node.val = val;
            node.left = new TreeNode();
            node.right = new TreeNode();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        clearNullTreeNode(root);
        return root;
    }

    private static void clearNullTreeNode(TreeNode root) {
        if(root == null) return;
        if(root.left.val == Integer.MAX_VALUE) root.left = null;
        if(root.right.val == Integer.MAX_VALUE) root.right = null;
        clearNullTreeNode(root.left);
        clearNullTreeNode(root.right);
    }

}