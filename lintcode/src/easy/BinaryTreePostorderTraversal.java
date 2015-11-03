package easy;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/10/31 14:29.
 */
public class BinaryTreePostorderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        postorderTraversal(arrayList, root);
        return arrayList;
    }

    public void postorderTraversal(List<Integer> list, TreeNode root) {
        if(root == null) return;
        if(root.left != null) postorderTraversal(list, root.left);
        if(root.right != null) postorderTraversal(list, root.right);
        list.add(root.val);
    }

}
