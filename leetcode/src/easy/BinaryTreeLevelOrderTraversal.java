package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class BinaryTreeLevelOrderTraversal {

    /**
     * Given a binary tree, return the level order traversal of its nodes'
     * values. (ie, from left to right, level by level).
     * 
     * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7
     * return its level order traversal as: [ [3], [9,20], [15,7] ]
     */
    
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
    
    /**
     * 层序遍历需要用到队列
     */
    
//    private int offerInqueue(TreeNode root){
//        int level = 0;
//        if(root.left != null)
//            level = offerInqueue(root.left);
//        if(root.right != null)
//            level = Math.max(level, offerInqueue(root.right));
//        return level+1;
//    }


    private Queue<TreeNode> queue = new LinkedList<TreeNode>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> childList = new ArrayList<Integer>();
        int currentLevel = 0;
        int nextLevel = 0;
        if(root == null)
            return null;
        queue.offer(root);
        currentLevel = 1;
        
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if(currentLevel == 0) {
                list.add(childList);
                childList = new ArrayList<Integer>();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
            if(node.left != null){
                queue.offer(node.left);
                nextLevel++;
            }
            if(node.right != null){
                queue.offer(node.right);
                nextLevel++;
            }
            if(currentLevel > 0){
                childList.add(node.val);
                currentLevel--;
            }
            
        }
        list.add(childList); // while (!queue.isEmpty()) 导致 最后一次 list.add(childList) 没有执行 在此补上
        return list;
    }
    

}
