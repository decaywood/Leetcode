package medium;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/5 15:53.
 *
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree.
 * Find all the keys of tree in range k1 to k2. i.e.
 * print all x such that k1<=x<=k2 and x is a key of given BST.
 * Return all the keys in ascending order.
 *
 * Example
 * If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 *
 *      20
 *     /  \
 *    8   22
 *   / \
 *  4   12
 *
 */
public class SearchRangeInBinarySearchTree {

    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        searchRange(root, arrayList, k1, k2);
        return arrayList;
    }

    public void searchRange(TreeNode root, List<Integer> list, int k1, int k2) {
        if(root == null) return;
        searchRange(root.left, list, k1, k2);
        if(root.val >= k1 && root.val <= k2) list.add(root.val);
        if(root.val <= k2) searchRange(root.right, list, k1, k2);
    }
}
