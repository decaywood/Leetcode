package medium;


import dataStructure.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {


    
    private TreeNode buildTree(int[] num, int start, int end){
     
        if(start > end)           //必须先做判断，以免多一个节点
            return null;
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = buildTree(num, start, mid-1); //mid已经建立了一个节点，所以跳过mid
        node.right = buildTree(num, mid+1, end);
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
        int len = num.length;
        if (num.length == 0) {
            return null;
        }
        TreeNode node = buildTree(num, 0, len - 1);
        return node;
    }
    
    public static void main(String[] args) {
        new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{1, 3});
    }
}
