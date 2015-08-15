package easy;


import dataStructure.TreeNode;

/**
 * 2014年11月13日
 * 
 * @author decaywood
 * 
 * 
 *    Given a binary tree, check whether it is a mirror of itself (ie,
 *    symmetric around its center).
 * 
 *    For example, this binary tree is symmetric:
 * 
 *         1 
 *        / \ 
 *       2   2 
 *      / \ / \
 *      3 4 4 3 
 *    But the following is not: 
 *         1 
 *        / \ 
 *        2 2 
 *         \ \
 *          3 3
 */
public class SymmetricTree {
    

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return checkSymmetric(root.left, root.right);
    }
 
    private boolean checkSymmetric(TreeNode leftChild, TreeNode rightChild){
       
        if(leftChild == null && rightChild == null) return true;
        if(leftChild == null || rightChild == null) return false;
       
        boolean check1 = checkSymmetric(leftChild.right, rightChild.left);
        boolean check2 = checkSymmetric(leftChild.left, rightChild.right);
       
        return leftChild.val == rightChild.val && check1 && check2;
    }
    
}
