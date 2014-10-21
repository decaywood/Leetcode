package leetCode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

    /**
     * Given a binary tree, return the bottom-up level order traversal of its
     * nodes' values. (ie, from left to right, level by level from leaf to
     * root).
     * 
     * For example: Given binary tree {3,9,20,#,#,15,7}, 
     * 
     *                                                   3
     *                                                  / \
     *                                                  9 20
     *                                                 / \
     *                                                15 7
     * return its bottom-up level order traversal as: [ [15,7], [9,20], [3] ]
     * confused what "{1,#,2,3}" means? > read more on how binary tree is
     * serialized on OJ.
  
     * Definition for binary tree public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        List<Integer> childList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int currentLevel = 0;
        int nextLevel = 0;
        if(root == null)
            return list;
        
        queue.offer(root);
        currentLevel = 1;
        
        while (!queue.isEmpty()) {
            
            TreeNode node = queue.poll();
            if(currentLevel == 0){
                list.addFirst(childList);
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
            if(currentLevel >0){
                childList.add(node.val);
                currentLevel--;
            }
        }
        list.addFirst(childList);
        
        
        return list;
    }
}
