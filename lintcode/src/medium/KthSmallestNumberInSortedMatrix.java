package medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author: decaywood
 * @date: 2015/10/31 12:19.
 *
 * Find the kth smallest number in at row and column sorted matrix.
 *
 * Example
 * Given k = 4 and a matrix:
 *
 * [
 *  [1 ,5 ,7],
 *  [3 ,7 ,8],
 *  [4 ,8 ,9],
 * ]
 * return 5
 *
 * Challenge
 * O(k log n), n is the maximal number in width and height.
 *
 */
public class KthSmallestNumberInSortedMatrix {

    private static class Point implements Comparable<Point> {
        int x, y, val;

        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public Point(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return val < o.val ? -1 : val > o.val ? 1 : 0;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int count = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Point p = new Point(matrix[0][0], 0, 0);
        Set<Point> set = new HashSet<>();
        set.add(p);
        queue.offer(p);
        int val = 0;
        while (count != k) {
            Point point = queue.poll();
            val = point.val;
            count++;
            if (point.x + 1 < matrix.length) {
                Point toAdd = new Point(matrix[point.x + 1][point.y], point.x + 1, point.y);
                if(!set.contains(toAdd)) {
                    queue.offer(toAdd);
                    set.add(toAdd);
                }
            }
            if (point.y + 1 < matrix[0].length) {
                Point toAdd = new Point(matrix[point.x][point.y + 1], point.x, point.y + 1);
                if(!set.contains(toAdd)) {
                    queue.offer(toAdd);
                    set.add(toAdd);
                }
            }
        }
        return val;
    }



}
