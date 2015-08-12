package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author decaywood
 * 
 * 2015年1月24日
 * 
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST
 * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 *
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 */
public class ConvertSortedListToBinarySearchTree {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; next = null; }
     }
     
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
     
     public TreeNode sortedListToBST(ListNode head) {
         
         List<Integer> list = new ArrayList<Integer>();
         
         while(head != null){
             list.add(head.val);
             head = head.next;
         }
         
         if(list.size() == 0) return null;
         
         TreeNode root = new TreeNode(0);
         fillTree(root, list, 0, list.size() - 1, true);
         
         return root;
     }
     
   
     
     private void fillTree(TreeNode root, List<Integer> list, int start, int end, boolean isLeft){
         
         if(start > end) return;
         
         int middle = isLeft ? (int) Math.ceil((start + end) / 2d) :
                               (int) Math.floor((start + end) / 2d);
         
         
         if(start <= middle - 1)
             root.left = new TreeNode(0);
         
             fillTree(root.left, list, start, middle - 1, true);
             
         
         root.val = list.get(middle);
         
         if(middle + 1 <= end)
             root.right = new TreeNode(0);
             fillTree(root.right, list, middle + 1, end, false);
         
         
     }
     
     private static void show(TreeNode node){
         if(node == null) return;
         
         show(node.left);
         System.out.println(node.val);
         show(node.right);
     }
     
     public static void main(String[] args) {
         ListNode node = new ListNode(1);
         node.next = new ListNode(2);
         node.next.next = new ListNode(3);
         node.next.next.next = new ListNode(4);
         node.next.next.next.next = new ListNode(5);
         node.next.next.next.next.next = new ListNode(6);
         node.next.next.next.next.next.next = new ListNode(7);
         node.next.next.next.next.next.next.next = new ListNode(8);
         show(new ConvertSortedListToBinarySearchTree().sortedListToBST(node));;
    }
     
}
