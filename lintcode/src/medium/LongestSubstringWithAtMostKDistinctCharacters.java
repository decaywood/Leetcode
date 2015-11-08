package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author: decaywood
 * @date: 2015/11/8 10:18.
 *
 * Given a string s, find the length of the longest substring T that contains at most k distinct characters.
 *
 * Example
 * For example, Given s = "eceba", k = 3,
 *
 * T is "eceb" which its length is 4.
 *
 * Challenge
 * O(n), n is the size of the string s.
 *
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (Character c : s.toCharArray()) {
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c) + 1);
            queue.offer(c);
            if (map.size() > k) {
                Character poll = queue.poll();
                map.put(poll, map.get(poll) - 1);
                if(map.get(poll) == 0) map.remove(poll);
                continue;
            }
            res = Math.max(res, queue.size());
        }
        return res;
    }


}
