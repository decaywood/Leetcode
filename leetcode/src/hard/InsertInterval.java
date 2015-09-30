package hard;

import dataStructure.Interval;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: decaywood
 * @date: 2015/9/29 10:47
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {



    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int[] index = new int[1];
        List<Interval> res = intervals.stream().filter(interval -> filter(interval, newInterval)).peek(x -> {
            if (x.start < newInterval.start) index[0]++;}).collect(Collectors.toList());
        res.add(index[0], newInterval);
        return res;
    }


    private boolean filter(Interval val, Interval compare) {
        boolean res = !(val.start <= compare.start && val.end >= compare.start || val.start <= compare.end && val.end >= compare.end||
                        val.start > compare.start && val.end > compare.start && val.start < compare.end && val.end < compare.end);
        if (val.start <= compare.start && val.end >= compare.start) compare.start = val.start;
        if (val.start <= compare.end && val.end >= compare.end) compare.end = val.end;
        return res;
    }

    public static void main(String[] args) {
        new InsertInterval().insert(Interval.generateTestCase("[1,5]"), new Interval(1,7));
    }

}
