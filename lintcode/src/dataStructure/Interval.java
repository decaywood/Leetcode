package dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/10/17 20:01.
 */


public class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static List<Interval> generateTestCase(String s) {
        List<Interval> res = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (String str : s.split("\\],\\[")) {
            String[] arr = str.split(",");
            Interval interval = new Interval(Integer.parseInt(arr[0].trim()), Integer.parseInt(arr[1].trim()));
            res.add(interval);
        }
        return res;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
