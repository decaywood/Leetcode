package medium;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/5 13:31.
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Example
 * Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
 *
 *       2
 *      / \
 *     1   3
 * Note
 * You may assume that duplicates do not exist in the tree.
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {


    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return buildTree(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if(preorderStart > preorderEnd) return null;
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int midIndex = inorderStart;
        for (; midIndex < inorderEnd; midIndex++)
            if(inorder[midIndex] == preorder[preorderStart]) break;
        root.left = buildTree(preorder, inorder, preorderStart + 1, preorderStart + midIndex - inorderStart, inorderStart, midIndex -1);
        root.right = buildTree(preorder, inorder, preorderStart + midIndex - inorderStart + 1, preorderEnd, midIndex + 1, inorderEnd);
        return root;
    }


}
