package easy;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePostorderTraversal {
    /**
     * 
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    private static class TreeNode{
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    
    private List<Integer> list = new ArrayList<Integer>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return list;
//        list.add(root.val); //preorder
        if(root.left != null)
            postorderTraversal(root.left);
        if(root.right != null)
            postorderTraversal(root.right);
        list.add(root.val); // postorder
        return list;
    }
   
}
