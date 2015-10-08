package medium;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/10/1 16:00
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *
 *      1
 *     / \
 *    2   5
 *   / \   \
 *  3   4   6
 *
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 *
 */
public class FlattenBinaryTreeToLinkedList {

    public TreeNode flatten(TreeNode root) {
        if(root == null) return null;
        flatten(root.left);
        flatten(root.right);
        if(root.left != null) {
            findLastNode(root.left).right = root.right;
            root.right = root.left;
        }
        root.left = null;
        return root;
    }

    private TreeNode findLastNode(TreeNode node) {
        while (node.right != null) node = node.right;
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(4);
        node2.right = new TreeNode(6);
        new FlattenBinaryTreeToLinkedList().flatten(root);
    }

}
