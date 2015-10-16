package medium;

/**
 * @author: decaywood
 * @date: 2015/10/15 11:07
 *
 * The structure of Segment Tree is a binary tree which each node has
 * two attributes start and end denote an segment / interval.
 *
 * start and end are both integers, they should be assigned in following rules:
 *
 * The root's start and end is given by build method.
 * The left child of node A has start=A.left, end=(A.left + A.right) / 2.
 * The right child of node A has start=(A.left + A.right) / 2 + 1, end=A.right.
 * if start equals to end, there will be no children for this node.
 * Implement a build method with a given array, so that we can create a corresponding segment tree with every node value represent the corresponding interval max value in the array, return the root of this segment tree.
 *
 * Example
 * Given [3,2,1,4]. The segment tree will be:
 *
 *                          [0,  3] (max = 4)
 *
 *                            /               \
 *
 *               [0,  1] (max = 3)          [2, 3]  (max = 4)
 *
 *                /           \                  /           \
 *
 *      [0, 0](max = 3)  [1, 1](max = 2)  [2, 2](max = 1) [3, 3] (max = 4)
 *
 * Clarification
 * Segment Tree (a.k.a Interval Tree) is an advanced data structure which can support queries like:
 *
 * which of these intervals contain a given point
 * which of these points are in a given interval
 * See wiki: Segment Tree Interval Tree
 *
 *
 * �߶�����һ�ö�����������ÿ���ڵ�������������������start��end���ڱ�ʾ�ýڵ�����������䡣
 * start��end�������������������µķ�ʽ��ֵ:
 * ���ڵ�� start �� end �� build ������������
 * ���ڽڵ� A ������ӣ��� start=A.left, end=(A.left + A.right) / 2��
 * ���ڽڵ� A ���Ҷ��ӣ��� start=(A.left + A.right) / 2 + 1, end=A.right��
 * ��� start ���� end, ��ô�ýڵ���Ҷ�ӽڵ㣬���������Ҷ��ӡ�
 * ʵ��һ�� build ���������� start �� end ��Ϊ����, Ȼ����һ���������� [start, end] ���߶�����
 * ÿ���ڵ���������������ֵ����������߶����ĸ���
 *
 */
public class SegmemtTreeBuildII {


    public class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }

    private SegmentTreeNode buildTreeNode(int[] A, int startIndex, int endIndex) {
        if(startIndex > endIndex) return null;
        if(startIndex == endIndex) return new SegmentTreeNode(startIndex, endIndex, A[startIndex]);
        SegmentTreeNode node = new SegmentTreeNode(startIndex, endIndex, 0);
        node.left = buildTreeNode(A, startIndex, (startIndex + endIndex) >> 1);
        node.right = buildTreeNode(A, ((startIndex + endIndex) >> 1) + 1, endIndex);
        node.max = Math.max(node.left == null ? 0 : node.left.max, node.right == null ? 0 : node.right.max);
        return node;
    }

    public SegmentTreeNode build(int[] A) {
        return buildTreeNode(A, 0, A.length - 1);
    }


}
