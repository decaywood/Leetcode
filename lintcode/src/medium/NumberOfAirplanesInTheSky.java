package medium;

import dataStructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/10/26 22:58.
 *
 * Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?
 *
 * Example
 * For interval list [[1,10],[2,3],[5,8],[4,7]], return 3
 *
 * Note
 * If landing and flying happens at the same time, we consider landing should happen at first.
 *
 */
public class NumberOfAirplanesInTheSky {

    private static class Key implements Comparable<Key> {
        int val = 0;
        boolean start;
        public Key(int val, boolean start) {
            this.val = val;
            this.start = start;
        }
        @Override
        public int compareTo(Key o) { return val > o.val ? 1 : val < o.val ? -1 : start ? 1 : -1; }

    }
    public int countOfAirplanes(List<Interval> airplanes) {
        List<Key> list = new ArrayList<>();
        for (Interval airplane : airplanes) {
            list.add(new Key(airplane.start, true));
            list.add(new Key(airplane.end, false));
        }
        Collections.sort(list);
        int count = 0;
        int max = 0;
        for (Key key : list) {
            count = count + (key.start ? 1 : -1);
            max = Math.max(max, count);
        }
        return max;
    }

}
