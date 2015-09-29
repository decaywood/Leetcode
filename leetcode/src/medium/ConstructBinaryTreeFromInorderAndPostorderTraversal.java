package medium;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/29 8:54
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd) return null;
        TreeNode node = new TreeNode(postorder[postEnd]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++)
            if(inorder[i] == postorder[postEnd]) {
                index = i;
                break;
            }
        node.left = buildTree(inorder, postorder, inStart, index - 1, postStart, postStart + index - inStart - 1);
        node.right = buildTree(inorder, postorder, index + 1, inEnd, postStart + index - inStart, postEnd - 1);
        return node;
    }

}
