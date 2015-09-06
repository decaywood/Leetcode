package medium;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: decaywood
 * @date: 2015/9/5 15:22.
 *
 * Design an algorithm and write code to serialize and deserialize a binary tree.
 * Writing the tree to a file is called 'serialization' and reading back from the file
 * to reconstruct the exact same binary tree is 'deserialization'.
 *
 * There is no limit of how you deserialize or serialize a binary tree,
 * you only need to make sure you can serialize a binary tree to a string
 * and deserialize this string to the original structure.
 *
 * Example
 * An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *
 * Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.
 *
 * You can use other method to do serializaiton and deserialization.
 *
 */
public class BinaryTreeSerialization {

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode dummyNode = new TreeNode(Integer.MAX_VALUE);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            builder.append(node.val).append(',');
            if(node.val == Integer.MAX_VALUE) continue;
            queue.offer(node.left == null ? dummyNode : node.left);
            queue.offer(node.right == null ? dummyNode : node.right);
        }
        return builder.substring(0, builder.length() - 1);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] strings = data.split(",");
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (String str : strings) {
            int num = Integer.parseInt(str);
            TreeNode node = queue.poll();
            if(num == Integer.MAX_VALUE) {
                if(queue.isEmpty()) break;
                continue;
            }
            node.val = num;
            node.left = new TreeNode(Integer.MAX_VALUE);
            node.right = new TreeNode((Integer.MAX_VALUE));
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
