package dataStructure;

/**
 * @author: decaywood
 * @date: 2015/11/9 13:00
 */
public class SegmentTreeNode {
    public int start, end, sum;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
        this(start, end, 0);
    }
    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = this.right = null;
    }
}