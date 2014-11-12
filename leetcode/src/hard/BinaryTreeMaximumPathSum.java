package hard;


public class BinaryTreeMaximumPathSum {
    
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
    private static int max = -1*(1<<30);
    public static int getMaxPathSum(TreeNode root) {
        
        if(root == null)
            return 0;
       
        int num1 = -1*(1<<30); // 不能取 Integer.MIN_VALUE ： 加法溢出
        int num2 = -1*(1<<30);
        int sum = root.val;
        int result = -1*(1<<30);
        if(root.left != null){
            num1 = getMaxPathSum(root.left);
            sum += num1;
        }
        if(root.right != null){
            num2 = getMaxPathSum(root.right);
            sum += num2;
        }
        max = Math.max(sum, max);
        max = Math.max(num1, max);
        max = Math.max(num2, max);
        result = Math.max(num1, num2);
        return Math.max(root.val, result + root.val);
        
    }
    
    public static int maxPathSum(TreeNode root) {
     
        int num = getMaxPathSum(root);
        return Math.max(max, num);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
       
        System.out.println( maxPathSum(root));
    }
}
