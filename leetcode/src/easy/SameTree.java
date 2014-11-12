package easy;

public class SameTree {
    
    /**
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
    
   public boolean isSameTree(TreeNode p, TreeNode q) {
       
       if(p == null || q== null){
           if(p == null && q == null)
              return true;
           else
              return false;
       }
       
       if(p.val != q.val)
           return false;
       
       boolean isSame = false;
       isSame = isSameTree(p.left, q.left);
       isSame = isSame && isSameTree(p.right, q.right);
       
       return isSame;
   }
}
