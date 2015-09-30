package dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/29 11:02
 *
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 *
 */

public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public static List<Interval> generateTestCase(String string) {
        List<Interval> res = new ArrayList<>();
        for (String s : string.substring(1, string.length() - 1).split("\\],\\[")) {
            String[] pair = s.split(",");
            res.add(new Interval(Integer.parseInt(pair[0]), Integer.parseInt(pair[1])));
        }
        return res;
    }
}
