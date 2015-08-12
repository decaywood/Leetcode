package leetcode.medium;

import java.util.Deque;
import java.util.Stack;

 
/**
 * 
 * @author decaywood
 * 
 * 2015年1月3日
 * 
 * Implement an iterator over a binary search tree (BST).
 *  Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
 * where h is the height of the tree.
 * 
 * 维护一个栈，从根节点开始，每次迭代地将根节点的左孩子压入栈，直到左孩子为空为止。
 * 调用next()方法时，弹出栈顶，如果被弹出的元素拥有右孩子，则以右孩子为根，将其左孩子迭代压栈。
 *
 */
public class BinarySearchTreeIterator {
    
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Stack<TreeNode> stack;
    
    public BinarySearchTreeIterator(TreeNode root) {
        
        stack = new Stack<TreeNode>();
        if(root != null)
            push(root);
    }
    
    private void push(TreeNode root){
        TreeNode node = root;
        stack.push(node);
        while(node.left != null){
            stack.push(node.left);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if(node.right != null)
            push(node.right);
        return node.val;
    }
    
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        BinarySearchTreeIterator searchTreeIterator = new BinarySearchTreeIterator(node);
        searchTreeIterator.next();
    }
    
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */