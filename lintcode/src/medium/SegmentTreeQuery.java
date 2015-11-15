package medium;

import dataStructure.SegmentTreeNode;

/**
 * @author: decaywood
 * @date: 2015/11/9 13:23
 *
 * For an integer array (index from 0 to n-1, where n is the size of this array),
 * in the corresponding SegmentTree,
 * each node stores an extra attribute max to denote the maximum number
 * in the interval of the array (index from start to end).
 *
 * Design a query method with three parameters root, start and end,
 * find the maximum number in the interval [start, end] by the given root of segment tree.
 *
 * Example
 * For array [1, 4, 2, 3], the corresponding Segment Tree is:
 *
 *                      [0, 3, max=4]
 *                      /           \
 *          [0,1,max=4]                [2,3,max=3]
 *           /         \               /         \
 *      [0,0,max=1] [1,1,max=4]     [2,2,max=2], [3,3,max=3]
 *
 * query(root, 1, 1), return 4
 * query(root, 1, 2), return 4
 * query(root, 2, 3), return 3
 * query(root, 0, 2), return 4
 *
 * Note
 * It is much easier to understand this problem if you finished Segment Tree Build first.
 *
 */
public class SegmentTreeQuery {

    public int query(SegmentTreeNode root, int start, int end) {
        if(start > end) return Integer.MIN_VALUE;
        if(root.start == start && root.end == end) return root.max;
        int start1 = Math.max(root.left.start, start);
        int end1 = Math.min(root.left.end, end);
        int start2 = Math.max(root.right.start, start);
        int end2 = Math.min(root.right.end, end);
        return Math.max(query(root.left, start1, end1), query(root.right, start2, end2));
    }

}
