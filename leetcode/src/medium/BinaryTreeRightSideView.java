package medium;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: decaywood
 * @date: 2015/7/26 14:36
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 *  2    3         <---
 *  \     \
 *  5      4       <---
 * You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        q.offer(root);
        level.offer(1);
        int flag = 0;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            int tempLevel = level.poll();
            if (tempLevel != flag) {
                res.add(temp.val);
                flag++;
            }
            if (temp.right != null) {
                q.offer(temp.right);
                level.offer(tempLevel + 1);
            }
            if (temp.left != null) {
                q.offer(temp.left);
                level.offer(tempLevel + 1);
            }
        }
        return res;
    }

}
