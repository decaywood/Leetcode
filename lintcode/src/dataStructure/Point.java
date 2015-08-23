package dataStructure;

/**
 * @author: decaywood
 * @date: 2015/8/22 21:28.
 */
public class Point {

    /**
     * Definition for a point.
     * class Point {
     *     int x;
     *     int y;
     *     Point() { x = 0; y = 0; }
     *     Point(int a, int b) { x = a; y = b; }
     * }
     */


    public int x;
    public int y;
    public Point() { x = 0; y = 0; }
    public Point(int a, int b) { x = a; y = b; }

    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }
}
