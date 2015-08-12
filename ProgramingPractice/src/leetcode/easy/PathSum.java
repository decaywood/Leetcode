package leetcode.easy;

/**
 * 2014年11月16日
 * @author decaywood
 *
 *
 *  Given a binary tree and a sum, 
 *  determine if the tree has a root-to-leaf path 
 *  such that adding up all the values along the path equals the given sum.
 *
 *  For example:
 *  Given the below binary tree and sum = 22,
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \      \
 *      7    2      1
 *  return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {

     
    private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if(root == null)
            return false;

        sum -= root.val;
        
        if(sum == 0 && root.left == null && root.right == null)
            return true;
        
        boolean check = false;
        
        if(root.left != null)  // 只要有一个返回true就行 所以要用或操作 
            check |= hasPathSum(root.left, sum);
        if(root.right != null)
            check |= hasPathSum(root.right, sum);
        
        return check;
    }
    
}
