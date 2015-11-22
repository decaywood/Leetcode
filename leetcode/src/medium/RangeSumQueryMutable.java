package medium;


/**
 * @author: decaywood
 * @date: 2015/11/22 15:15.
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 */
public class RangeSumQueryMutable {

    public static class SegmentTreeNode {
        public int start, end, sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    private SegmentTreeNode root;

    void update(int i, int val) {
        updateTree(i, val, root);
    }

    public RangeSumQueryMutable(int[] nums) {
        root = buildTreeNode(nums, 0, nums.length - 1);
    }


    public int sumRange(int i, int j) {
        return treeSum(i, j, root);
    }

    private int treeSum(int start, int end, SegmentTreeNode root) {
        if(root == null || start > root.end || end < root.start) return 0;
        if(start == root.start && end == root.end) return root.sum;
        int leftSum = root.left == null ? 0 : treeSum(Math.max(root.left.start, start), Math.min(root.left.end, end), root.left);
        int rightSum = root.right == null ? 0 : treeSum(Math.max(root.right.start, start), Math.min(root.right.end, end), root.right);
        return leftSum + rightSum;
    }

    private SegmentTreeNode buildTreeNode(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end) return new SegmentTreeNode(start, end, nums[start]);
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        int mid = start + (end - start) / 2;
        root.left = buildTreeNode(nums, start, mid);
        root.right = buildTreeNode(nums, mid + 1, end);
        root.sum = (root.left == null ? 0 : root.left.sum) + (root.right == null ? 0 : root.right.sum);
        return root;
    }

    private void updateTree(int index, int val, SegmentTreeNode root) {
        if(root.start > index || root.end < index) return;
        int start = root.start;
        int end = root.end;
        if(start == end) {
            root.sum = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if(index > mid) updateTree(index, val, root.right);
        else updateTree(index, val, root.left);
        root.sum = (root.left == null ? 0 : root.left.sum) + (root.right == null ? 0 : root.right.sum);
    }

    public static void main(String[] args) {
        RangeSumQueryMutable r = new RangeSumQueryMutable(new int[]{0,9,5,7,3});
        System.out.println(r.sumRange(4, 4));
        System.out.println(r.sumRange(2, 4));
        System.out.println(r.sumRange(3, 3));
        r.update(4, 5);
        r.update(1, 7);
        r.update(0, 8);
        System.out.println(r.sumRange(1, 2));
        r.update(1, 9);
        System.out.println(r.sumRange(4, 4));
    }

}
