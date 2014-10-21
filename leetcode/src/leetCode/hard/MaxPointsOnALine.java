package leetCode.hard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MaxPointsOnALine {
    
    /**
     * Definition for a point.
     * class Point {
     *     int x;
     *     int y;
     *     Point() { x = 0; y = 0; }
     *     Point(int a, int b) { x = a; y = b; }
     * }
     */
    
    private static class Point{
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    
    public static int maxPoints(Point[] points) {
        if(points.length == 0||points == null) 
            return 0;  
            
        if(points.length == 1) 
            return 1;  
            
        int max = 1;  //the final max value, at least one
        for(int i = 0; i < points.length; i++) {  
            HashMap<Float, Integer> hm = new HashMap<Float, Integer>();  
           int same = 0;
            int localmax = 1; //the max value of current slope, at least one
            for(int j = 0; j < points.length; j++) {  
                if(i == j) 
                    continue;  
                    
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    same++; 
                    continue;
                }
                
                float slope = ((float)(points[i].y - points[j].y))/(points[i].x - points[j].x); 
                
                if(hm.containsKey(slope))  
                    hm.put(slope, hm.get(slope) + 1);  
                else  
                    hm.put(slope, 2);  //two points form a line
            }
            
            for (Integer value : hm.values())   
                localmax = Math.max(localmax, value);  
          
            localmax += same;  
            max = Math.max(max, localmax);  
        }  
        return max; 
    }
    
    public static void main(String[] args) {
        Point[] points = new Point[]{ new Point(0, 1), new Point(0,2),new Point(2, 0),new Point(2,5), new Point(2,4) }; //(3,10),(0,2),(0,2),(3,10)
        int max = maxPoints(points);
        System.out.println(max);
    }
}
