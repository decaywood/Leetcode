package medium;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/11/8 17:34.
 *
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 *
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 *
 * Example
 * For the following binary tree:
 *
 *      4
 *     / \
 *    3   7
 *       / \
 *      5   6
 *
 * LCA(3, 5) = 4
 *
 * LCA(5, 6) = 7
 *
 * LCA(6, 7) = 7
 *
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null) return null;
        TreeNode node = lowestCommonAncestor(root.left, A, B);
        node = node == null ? lowestCommonAncestor(root.right, A, B) : node;
        if(node == null && contains(root, A) && contains(root, B)) return root;
        return node;
    }

    private boolean contains(TreeNode root, TreeNode node) {
        if(root == null) return false;
        else if(root == node) return true;
        return contains(root.right, node) || contains(root.left, node);
    }

}
