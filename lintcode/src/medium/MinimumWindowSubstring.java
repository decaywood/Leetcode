package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author: decaywood
 * @date: 2015/11/8 20:23.
 *
 * Given a string source and a string target, find the minimum window in source which will contain all the characters in target.
 *
 * Example
 * source = "ADOBECODEBANC" target = "ABC" Minimum window is "BANC".
 *
 * Note
 * If there is no such window in source that covers all characters in target, return the emtpy string "".
 *
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.
 *
 * Challenge
 * Can you do it in time complexity O(n) ?
 *
 * Clarification
 * Should the characters in minimum window has the same order in target?
 *
 * - Not necessary.
 *
 */
public class MinimumWindowSubstring {

    public String minWindow(String source, String target) {
        Map<Character, Integer> strTable = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        for (char c : target.toCharArray()) {
            if(!strTable.containsKey(c)) strTable.put(c, 0);
            strTable.put(c, strTable.get(c) + 1) ;
        }
        Queue<Character> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (Character c : source.toCharArray()) {
            queue.offer(c);
            if (target.indexOf(c) != -1) {
                if(!count.containsKey(c)) count.put(c, 0);
                count.put(c, count.get(c) + 1) ;
            }
            while (!queue.isEmpty() && (target.indexOf(queue.peek()) == -1 || count.get(queue.peek()) > strTable.get(queue.peek()))) {
                char poll = queue.poll();
                if (target.indexOf(poll) != -1) count.put(poll, count.get(poll) - 1);
            }
            boolean check = true;
            for (Character character : strTable.keySet()) {
                if(count.get(character) == null || count.get(character) < strTable.get(character)) {
                    check = false;
                    break;
                }
            }
            if (check && queue.size() < minLen) {
                minLen = queue.size();
                builder.delete(0, builder.length());
                for (Character character : queue) {
                    builder.append(character);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("asdfadfaidyfaksdhadhfadufaoidfadfbadf", "asfadbd"));
    }
}
