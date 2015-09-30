package hard;


import dataStructure.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/29 12:47
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals.size() == 0) return list;
        intervals.sort((x, y) -> x.start == y.start ? 0 : x.start > y.start ? 1 : -1);
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            Interval pre = list.get(list.size() - 1);
            if(interval.start > pre.end && interval.end > pre.end) list.add(interval);
            else {
                pre.start = Math.min(interval.start, pre.start);
                pre.end = Math.max(interval.end, pre.end);
            }
        }
        return list;
    }



}
