package leetCode.medium;

public class PopulatingNextRightPointersInEachNode {
    
    /*
     *   Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     *
     *   Initially, all next pointers are set to NULL.
     *   
     *   Note:
     *   
     *   You may only use constant extra space.
     *   You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
     *   For example,
     *   Given the following perfect binary tree,
     *            1
     *          /  \
     *         2    3
     *        / \  / \
     *       4  5  6  7
     *   After calling your function, the tree should look like:
     *            1 -> NULL
     *          /  \
     *        2 -> 3 -> NULL
     *        / \  / \
     *      4->5->6->7 -> NULL
     */
    
    
    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     *     int val;
     *     TreeLinkNode left, right, next;
     *     TreeLinkNode(int x) { val = x; }
     * }
     */
    
    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    
    public void connect(TreeLinkNode root) {  //注意递归顺序  必须先建立上层节点的兄弟间连接再进行子节点的连接
        if(root == null)
            return;
        if(root.right != null){
            if(root.next != null)
                root.right.next = root.next.left;
            connect(root.right);
        }
        
        if(root.left != null){
            root.left.next = root.right;
            connect(root.left);
        }
    }
    
}
