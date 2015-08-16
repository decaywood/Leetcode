package easy;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/8/16 11:06
 *
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *
 *      1
 *    /   \
 *   2     3
 *    \
 *     5
 *
 * All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 */


public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, paths, new StringBuilder());
        return paths;
    }

    public static void binaryTreePaths(TreeNode root, List<String> paths, StringBuilder builder) {
        if(root == null) return;
        if(root.left == null && root.right == null) paths.add(builder.append("->").append(root.val).substring(2));
        builder.append("->").append(root.val);
        if(root.left != null) binaryTreePaths(root.left, paths, new StringBuilder(builder.toString()));
        if(root.right != null) binaryTreePaths(root.right, paths, new StringBuilder(builder.toString()));
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        for (String s : binaryTreePaths(node1)) {
            System.out.println(s);
        }

    }
}
