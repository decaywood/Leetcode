package leetcode.medium;

/**
 * @author: decaywood
 * @date: 2015/7/26 11:49
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ¡Ü k ¡Ü BST's total elements.
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations)
 * often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInABST {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    private static class Adder {
        int count;
        public void add() {
            count++;
        }
        public boolean valEqual(int x) {
            return count == x;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        return kthSmallest(root, new Adder(), k);
    }

    public static int kthSmallest(TreeNode root, Adder adder, int k) {
        int val = 0;
        if(root.left != null)
            val = kthSmallest(root.left, adder, k);
        if(adder.valEqual(k)) return val;

        adder.add();
        if ((adder.valEqual(k))) return root.val;

        if(root.right != null) val = kthSmallest(root.right, adder, k);
        return val;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node.left = node1;
        System.out.println(kthSmallest(node, 2));

    }

}
