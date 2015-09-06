package medium;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/6 14:08
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(
            int[] inorder,
            int[] postorder,
            int inorderStart,
            int inorderEnd,
            int postorderStart,
            int postorderEnd) {
        if(inorderStart > inorderEnd) return null;
        int midIndex = 0;
        for (int i = inorderStart; i <= inorderEnd; i++)
            if(inorder[i] == postorder[postorderEnd]) {
                midIndex = i;
                break;
            }
        TreeNode treeNode = new TreeNode(inorder[midIndex]);
        treeNode.left = buildTree(inorder, postorder, inorderStart, midIndex - 1, postorderStart, postorderStart + midIndex - inorderStart - 1);
        treeNode.right = buildTree(inorder, postorder, midIndex + 1, inorderEnd, postorderStart + midIndex - inorderStart, postorderEnd - 1);
        return treeNode;
    }
}
