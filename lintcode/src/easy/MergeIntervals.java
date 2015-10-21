package easy;

import dataStructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/10/17 20:00.
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example
 * Given intervals => merged intervals:
 *
 * [                     [
 *  [1, 3],               [1, 6],
 *  [2, 6],      =>       [8, 10],
 *  [8, 10],              [15, 18]
 *  [15, 18]             ]
 * ]
 * Challenge
 * O(n log n) time and O(1) extra space.
 *
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start < o2.start ? -1 : o1.start > o2.start ? 1 : 0;
            }
        });
        intervals.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
        List<Interval> res = new ArrayList<>();
        Interval temp = null;
        for (Interval interval : intervals) {
            if (temp != null && temp.end >= interval.start) {
                if(temp.end >= interval.end) continue;
                temp.end = interval.end;
            } else {
                if (temp != null) res.add(temp);
                temp = interval;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> l = new MergeIntervals().merge(Interval.generateTestCase("[2,3],[4,5],[6,7],[8,9],[1,10]"));
        for (Interval interval : l) {
            System.out.println(interval);
        }
    }

}
