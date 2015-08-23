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

    public static void main(String[] args) {
        String s = "40,-23],[9,138],[429,115],[50,-17],[-3,80],[-10,33],[5,-21],[-3,80],[-6,-65],[-18,26],[-6,-65],[5,72],[0,77],[-9,86],[10,-2],[-8,85],[21,130],[18,-6],[-18,26],[-1,-15],[10,-2],[8,69],[-4,63],[0,3],[-4,40],[-7,84],[-8,7],[30,154],[16,-5],[6,90],[18,-6],[5,77],[-4,77],[7,-13],[-1,-45],[16,-5],[-9,86],[-16,11],[-7,84],[1,76],[3,77],[10,67],[1,-37],[-10,-81],[4,-11],[-20,13],[-10,77],[6,-17],[-27,2],[-10,-81],[10,-1],[-9,1],[-8,43],[2,2],[2,-21],[3,82],[8,-1],[10,-1],[-9,1],[-12,42],[16,-5],[-5,-61],[20,-7],[9,-35],[10,6],[12,106],[5,-21],[-5,82],[6,71],[-15,34],[-10,87],[-14,-12],[12,106],[-5,82],[-46,-45],[-4,63],[16,-5],[4,1],[-3,-53],[0,-17],[9,98],[-18,26],[-9,86],[2,77],[-2,-49],[1,76],[-3,-38],[-8,7],[-17,-37],[5,72],[10,-37],[-4,-57],[-3,-53],[3,74],[-3,-11],[-8,7],[1,88],[-12,42],[1,-37],[2,77],[-6,77],[5,72],[-4,-57],[-18,-33],[-12,42],[-9,86],[2,77],[-8,77],[-3,77],[9,-42],[16,41],[-29,-37],[0,-41],[-21,18],[-27,-34],[0,77],[3,74],[-7,-69],[-21,18],[27,146],[-20,13],[21,130],[-6,-65],[14,-4],[0,3";
        String[] a = s.split("\\],\\[");
        Point[] points = new Point[a.length];
        for (int i = 0; i < a.length; i++) {
            String[] s2 = a[i].split(",");
            Point p = new Point(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
            points[i] = p;
        }
        System.out.println(maxPoints(points));
    }
}
