package medium;

import dataStructure.Point;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/8/22 21:27.
 *
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 *
 */
public class MaxPointsOnALine {
    public static int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        Map<Double, Integer> vectorCount = new HashMap<>();
        List<Point> list = new ArrayList<>();
        int maxCount = 1;
        for (Point point : points) {
            vectorCount.clear();
            int samePoint = 1;
            for (Point listPoint : list) {
                double x = point.x - listPoint.x;
                double y = point.y - listPoint.y;
                if(x == 0 && y == 0) {
                    samePoint++;
                    maxCount = Math.max(maxCount, samePoint);
                    continue;
                }
                double key = x == 0 ? point.x * Math.PI * 31 : y / x;
                key = y == 0 ? point.y * Math.PI * 31 : key;
                if (!vectorCount.containsKey(key)) vectorCount.put(key, 0);
                vectorCount.put(key, vectorCount.get(key) + 1);
                maxCount = Math.max(maxCount, vectorCount.get(key) + samePoint);
            }
            list.add(point);
        }
        return maxCount;
    }


}
