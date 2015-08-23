package hard;

import dataStructure.Point;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/8/23 13:02.
 *
 * Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
 * Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
 * The list pair has k operator and each operator has two integer A[i].x, A[i].y
 * means that you can change the grid matrix[A[i].x][A[i].y] from sea to island.
 * Return how many island are there in the matrix after each operator.
 *
 * Example
 * Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
 *
 * return [1,1,2,2].
 *
 * Note
 * 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent,
 * we consider them in the same island. We only consider up/down/left/right adjacent.
 *
 */
public class NumberOfIslandsII {

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        int id = 1;
        Map<Integer, LinkedList<Point>> islandMapper = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if(operators == null || operators.length == 0) return list;
        int[][] map = new int[Math.max(n, m) + 1][];
        for (int i = 0; i < Math.max(n, m) + 1; i++) {
            map[i] = new int[Math.max(n, m) + 1];
        }
        for (Point point : operators) {
            if(map[point.x][point.y] != 0) continue;
            int mergeID = 0;
            if(point.x > 0 && map[point.x - 1][point.y] != 0)
                mergeID = merge(map, islandMapper, mergeID, map[point.x - 1][point.y]);
            if(map[point.x + 1][point.y] != 0)
                mergeID = merge(map, islandMapper, mergeID, map[point.x + 1][point.y]);
            if(point.y > 0 && map[point.x][point.y - 1] != 0)
                mergeID = merge(map, islandMapper, mergeID, map[point.x][point.y - 1]);
            if(map[point.x][point.y + 1] != 0)
                mergeID = merge(map, islandMapper, mergeID, map[point.x][point.y + 1]);
            if(mergeID != 0) {
                islandMapper.get(mergeID).add(point);
                map[point.x][point.y] = mergeID;
            }
            else {
                map[point.x][point.y] = id;
                LinkedList<Point> linkedList = new LinkedList<>();
                linkedList.add(point);
                islandMapper.put(id, linkedList);
                id++;
            }
            list.add(islandMapper.size());
        }
        return list;
    }

    public int merge(int[][] map, Map<Integer, LinkedList<Point>> islandMapper, int id1, int id2) {
        if(id1 == 0 || id2 == 0) return id1 == 0 ? id2 : id1;
        if(id1 == id2) return id1;
        int smallSizeID = islandMapper.get(id1).size() < islandMapper.get(id2).size() ? id1 : id2;
        int largeSizeID = smallSizeID == id1 ? id2 : id1;
        for (Point point : islandMapper.get(smallSizeID)) map[point.x][point.y] = largeSizeID;
        islandMapper.get(largeSizeID).addAll(islandMapper.get(smallSizeID));
        islandMapper.remove(smallSizeID);
        return largeSizeID;
    }

    public static void main(String[] args) {
        String s = "0,9],[5,4],[0,12],[6,9],[6,5],[0,4],[4,11],[0,0],[3,5],[6,7],[3,12],[0,5],[6,13],[7,5],[3,6],[4,4],[0,8],[3,1],[4,6],[6,1],[5,12],[3,8],[7,0],[2,9],[1,4],[3,0],[1,13],[2,13],[6,0],[6,4],[0,13],[0,3],[7,4],[1,8],[5,5],[5,7],[5,10],[5,3],[6,10],[6,2],[3,10],[2,7],[1,12],[5,0],[4,5],[7,13],[3,2";
        String[] a = s.split("\\],\\[");
        Point[] points = new Point[a.length];
        for (int i = 0; i < a.length; i++) {
            String[] s2 = a[i].split(",");
            Point p = new Point(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
            points[i] = p;
        }
        List<Integer> list = new NumberOfIslandsII().numIslands2(8, 14, points);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    
}
