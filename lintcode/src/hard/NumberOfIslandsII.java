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


}
