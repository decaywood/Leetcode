package leetcode.easy;


public class BalancedBinaryTree {

    /**
     * Given a binary tree, determine if it is height-balanced.
     * 
     * For this problem, a height-balanced binary tree is defined as a binary
     * tree in which the depth of the two subtrees of every node never differ by
     * more than 1.
     * 
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    
    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    
    public int findDepth(TreeNode root){
        int depthL = 0; 
        int depthR = 0;
        
        if(root.left != null)
            depthL = findDepth(root.left);
        if(root.right != null)
            depthR = findDepth(root.right);
        if(Math.abs(depthL - depthR) > 1)
            isBalanced = false;
        return Math.max(depthL, depthR) + 1;  
    } 
    
    boolean isBalanced = true;
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return false;
        findDepth(root);
        return isBalanced;
    }
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        new BalancedBinaryTree().isBalanced(node1);
    }
}
