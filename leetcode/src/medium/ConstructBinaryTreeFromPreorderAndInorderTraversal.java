package medium;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/28 22:37
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart >= preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = inStart;; i++)
            if(inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }

        root.left = buildTree(preorder, inorder, preStart + 1, preStart + 1 + index - inStart, inStart, index);
        root.right = buildTree(preorder, inorder, preStart + 1 + index - inStart, preEnd, index + 1, inEnd);
        return root;
    }


}
