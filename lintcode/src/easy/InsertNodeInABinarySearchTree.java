package easy;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/5 9:40.
 *
 * Given a binary search tree and a new tree node, insert the node into the tree.
 * You should keep the tree still be a valid binary search tree.
 *
 * Example
 * Given binary search tree as follow, after Insert node 6, the tree should be:
 *
 *      2             2
 *     / \           / \
 *    1   4   -->   1   4
 *       /             / \
 *      3             3   6
 * Challenge
 * Can you do it without recursion?
 *
 */
public class InsertNodeInABinarySearchTree {

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        TreeNode pointer = root;
        while (pointer != null) {
            if(pointer.val < node.val && pointer.right == null) {
                pointer.right = node;
                break;
            } else if(pointer.val >= node.val && pointer.left == null) {
                pointer.left = node;
                break;
            }
            pointer = pointer.val < node.val ? pointer.right : pointer.left;
        }
        return root == null ? node : root;
    }

}
