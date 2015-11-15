package medium;

import dataStructure.Interval;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/11/9 10:45
 * <p>
 * Given an integer array (index from 0 to n-1,
 * where n is the size of this array), and an query list.
 * Each query has two integers [start, end]. For each query,
 * calculate the minimum number between index start and end in the given array, return the result list.
 * <p>
 * Example
 * For array [1,2,7,8,5], and queries [(1,2),(0,4),(2,4)], return [2,1,5]
 * <p>
 * Note
 * We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.
 * <p>
 * Challenge
 * O(logN) time for each query
 */
public class IntervalMinimumNumber {
    private static class Segment {
        int start, end, min;
        Segment left, right;
        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private Segment buildSegmentTree(int[] arr, int start, int end) {
        Segment segment = new Segment(start, end);
        if(start == end) {
            segment.min = arr[start];
            return segment;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) min = Math.min(min, arr[i]);
        segment.min = min;
        int mid = start + (end - start + 1) / 2;
        segment.left = buildSegmentTree(arr, start, mid - 1);
        segment.right = buildSegmentTree(arr, mid, end);
        return segment;
    }

    private int query(Segment segment, int start, int end) {
        if(start > end) return Integer.MAX_VALUE;
        if(segment.start == start && segment.end == end) return segment.min;
        int start1 = Math.max(segment.left.start, start);
        int end1 = Math.min(segment.left.end, end);
        int start2 = Math.max(segment.right.start, start);
        int end2 = Math.min(segment.right.end, end);
        return Math.min(query(segment.left, start1, end1), query(segment.right, start2, end2));
    }

    public ArrayList<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries) {
        Segment root = buildSegmentTree(A, 0, A.length - 1);
        ArrayList<Integer> res = new ArrayList<>();
        for (Interval query : queries) res.add(query(root, query.start, query.end));
        return res;
    }


}
