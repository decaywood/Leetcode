package medium;

import java.util.ArrayList;
import java.util.List;


public class SumRootToLeafNumbers {

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf
     * path could represent a number.
     * 
     * An example is the root-to-leaf path 1->2->3 which represents the number
     * 123.
     * 
     * Find the total sum of all root-to-leaf numbers.
     * 
     * For example,
     *   1
     *  / \ 
     * 2   3
     * The root-to-leaf path 1->2 represents the number 12. The
     * root-to-leaf path 1->3 represents the number 13.
     * 
     * Return the sum = 12 + 13 = 25.
    
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
    
    public int sumNumbers(TreeNode root) {
        List<Integer> allNumbers = new ArrayList<Integer>();
        treeRecursion(allNumbers, root, 0);
        int sum = 0;
        for(int number : allNumbers){
            sum += number;
        }
        return sum;
    }
    
    public void treeRecursion(List<Integer> allNumbers, TreeNode root, int topDigit) {
        if(root == null){
            return;
        }
            
        int currentVal = root.val;
        topDigit = topDigit * 10 + currentVal;
        if(root.left == null && root.right == null){
            allNumbers.add(topDigit);
            return;
        }
        treeRecursion(allNumbers, root.left, topDigit);
        treeRecursion(allNumbers, root.right, topDigit);
        
    }
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        new SumRootToLeafNumbers().sumNumbers(node1);
    }
    
}
