package easy;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2016/1/27 9:30
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Example
 * Given the following binary tree:
 * 
 *           1
 *         /   \
 *        2     3
 *         \
 *          5
 * All root-to-leaf paths are:
 * 
 * [
 *  "1->2->5",
 *  "1->3"
 * ]
 *
 */
public class BinaryTreePaths {

    /**
     * 递归
     */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getPath(list, root, "");
        return list;
    }

    private void getPath(List<String> res, TreeNode root, String path) {
        if (root == null) return;
        path = path + "->" + root.val;
        if(root.left == null && root.right == null) res.add(path.substring(2));
        getPath(res, root.left, path);
        getPath(res, root.right, path);
    }


}
