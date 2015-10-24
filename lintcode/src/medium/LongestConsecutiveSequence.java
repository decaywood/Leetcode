package medium;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/10/9 20:53.
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Example
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Clarification
 * Your algorithm should run in O(n) complexity.
 *
 */
public class LongestConsecutiveSequence {

    private static class Pair {
        int head = 0;
        int tail = 0;
        int count = 0;

        public Pair(int head, int tail, int count) {
            this.head = head;
            this.tail = tail;
            this.count = count;
        }
    }
    public int longestConsecutive(int[] num) {
        Map<Integer, Pair> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : num) {
            if(set.contains(i)) continue;
            set.add(i);
            merge(map, i);
        }
        int res = 0;
        for (Pair pair : map.values()) res = Math.max(res, pair.count);
        return res;
    }

    private void merge(Map<Integer, Pair> map, int i) {
        if (map.containsKey(i - 1) && map.containsKey(i + 1)) {
            Pair pairLeft = map.get(i - 1);
            Pair pairRight = map.get(i + 1);
            int left = pairLeft.head;
            int right = pairRight.tail;
            Pair pair = new Pair(left, right, pairLeft.count + pairRight.count + 1);
            map.remove(i - 1);
            map.remove(i + 1);
            map.put(left, pair);
            map.put(right, pair);
        } else if (map.containsKey(i - 1)) {
            Pair pair = map.get(i - 1);
            if (pair.head != pair.tail) map.remove(i - 1);
            pair.tail = i;
            map.put(i, pair);
            pair.count++;
        } else if (map.containsKey(i + 1)) {
            Pair pair = map.get(i + 1);
            if (pair.head != pair.tail) map.remove(i + 1);
            pair.head = i;
            map.put(i, pair);
            pair.count++;
        } else map.put(i, new Pair(i, i, 1));
    }



}
