package easy;


import dataStructure.TreeNode;

public class MaximumDepthOfBinaryTree {
    
    /**
     * Given a binary tree, find its maximum depth.
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * 
     */
    

    
//    public int findMaxDepth(TreeNode root){
//        int depthL = 0; 
//        int depthR = 0;
//        
//        if(root.left != null)
//            depthL = findMaxDepth(root.left);
//        if(root.right != null)
//            depthR = findMaxDepth(root.right);
//        
//        return Math.max(depthL, depthR) + 1;
//    }
    
    
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int childDepth = 0;
        if(root.left != null)
            childDepth = Math.max(childDepth, maxDepth(root.left));
        if(root.right != null)
            childDepth = Math.max(childDepth, maxDepth(root.right));
        return childDepth + 1;
    }
}

