package medium;

import dataStructure.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/7/19 12:52
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * ¡°The lowest common ancestor is defined between two nodes v and w as the lowest node in T
 * that has both v and w as descendants (where we allow a node to be a descendant of itself).¡±
 *
 *          _______3______
 *         /              \
 *      ___5__          ___1__
 *     /      \        /      \
 *     6      _2       0       8
 *           /  \
 *           7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 * Another example is LCA of nodes 5 and 4 is 5,
 * since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestorOfABinaryTree {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root; // if find at root, no need to continue, this is before branching
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) //after branching
            return root;
        return left == null?right:left;//one branch null or branch not null, the brach without null automatically becomes the lca
        //both null and root doesn't match, then return null
    }

    public static void main(String[] args) {
        TreeNode l0 = new TreeNode(37);
        TreeNode l1 = new TreeNode(-34);
        TreeNode l11 = new TreeNode(-48);
        TreeNode l2 = new TreeNode(-100);
        TreeNode l22 = new TreeNode(-100);
        TreeNode l222= new TreeNode(48);
        TreeNode l3 = new TreeNode(-54);
        TreeNode l4 = new TreeNode(-71);
        TreeNode l44 = new TreeNode(-22);
        TreeNode l5 = new TreeNode(8);
        l0.left = l1;
        l0.right = l11;
        l1.right = l2;
        l11.left = l22;
        l11.right = l222;
        l222.left = l3;
        l3.left = l4;
        l3.right = l44;
        l44.right = l5;

        TreeNode target =
                new LowestCommonAncestorOfABinaryTree()
                        .lowestCommonAncestor(l0, new TreeNode(-71), new TreeNode(-100));


    }
}
