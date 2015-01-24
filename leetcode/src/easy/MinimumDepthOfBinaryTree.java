package easy;

/**
 * @author decaywood
 * 
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along 
 * the shortest path from the root node down to the nearest leaf node.
 * 
 * 2015年1月23日
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 思路：通过递归返回左右子树最短路径，进行判断即可
 * 
 */
public class MinimumDepthOfBinaryTree {
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }        
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return countDepth(0, root);
    }
    
    private int countDepth(int depth, TreeNode node){
        
        depth++;
        if(node.left == null && node.right == null) return depth;
        int level = Integer.MAX_VALUE;
        if(node.left != null)
            level = Math.min(level, countDepth(depth, node.left));
        if(node.right != null)
            level = Math.min(level, countDepth(depth, node.right));
        
        return level == Integer.MAX_VALUE ? depth : level;
        
    }
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = node2;
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(node1));;
    }

}
