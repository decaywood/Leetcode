package easy;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/10/22 23:43.
 *
 * Given a sorted (increasing order) array, Convert it to create a binary tree with minimal height.
 *
 * Example
 * Given [1,2,3,4,5,6,7], return
 *
 *        4
 *      /   \
 *     2     6
 *    / \    / \
 *   1   3  5   7
 *
 * Note
 * There may exist multiple valid solutions, return any of them.
 *
 */
public class ConvertSortedArrayToBinarySearchTreeWithMinimalHeight {

    public TreeNode sortedArrayToBST(int[] A) {
        return sortedArrayToBST(A, 0, A.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] A, int left, int right) {
        if(left > right) return null;
        if(left == right) return new TreeNode(A[left]);
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = sortedArrayToBST(A, left, mid - 1);
        root.right = sortedArrayToBST(A, mid + 1, right);
        return root;
    }

}
