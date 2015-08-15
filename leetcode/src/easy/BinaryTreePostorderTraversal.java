package easy;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePostorderTraversal {

    
    private List<Integer> list = new ArrayList<Integer>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return list;
//        list.add(root.val); //preorder
        if(root.left != null)
            postorderTraversal(root.left);
        if(root.right != null)
            postorderTraversal(root.right);
        list.add(root.val); // postorder
        return list;
    }
   
}
