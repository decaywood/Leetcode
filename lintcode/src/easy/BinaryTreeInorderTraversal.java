package easy;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/9/6 10:57
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example
 * Given binary tree {1,#,2,3},
 *
 *      1
 *       \
 *        2
 *       /
 *      3
 *
 * return [1,3,2].
 *
 * Challenge
 * Can you do it without recursion?
 *
 */
public class BinaryTreeInorderTraversal {

   public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null) return arrayList;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pointer = root;
        for (;!stack.isEmpty() || pointer != null;) {
            if(pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            }
            else {
                pointer = stack.pop();
                arrayList.add(pointer.val);
                pointer = pointer.right;
            }
        }
        return arrayList;
    }



  /*  public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(list, root);
        return list;
    }

    public void inorderTraversal(ArrayList<Integer> list, TreeNode root){
        if(root == null) return;
        inorderTraversal(list, root.left);
        list.add(root.val);
        inorderTraversal(list, root.right);
    }*/

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTestCase("6,4,9,2,5,7,10");
        new BinaryTreeInorderTraversal().inorderTraversal(root);
    }

}
