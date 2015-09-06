package hard;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/6 9:40
 *
 * ˼·��
 * ɾ��һ���ڵ��Ϊ���������Ҫɾ���Ľڵ��Ϊz����
 * 1����zû����Ů�����޸��丸�ڵ�p[z]ʹ��Ϊnull
 * 2����zֻ��һ����Ů�������ͨ�������ӽڵ��븸�ڵ㽨��һ��������ɾ��
 * 3����z��������Ů����ɾ��z�ĺ��y��yû������Ů--yΪz����������С�ڵ㣩��Ȼ��y��val����z��val
 */
public class RemoveNodeInBinarySearchTree {

    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null) return null;
        if (value < root.val) root.left = removeNode(root.left, value);
        if (value > root.val) root.right = removeNode(root.right, value);
        if (value == root.val) {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.val = successor.val;
            root.right = removeNode(root.right, successor.val);
        }
        return root;
    }

}
