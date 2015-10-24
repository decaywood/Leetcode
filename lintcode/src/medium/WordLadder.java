package medium;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/9/7 9:23
 *
 * Given two words (start and end), and a dictionary,
 * find the length of shortest transformation sequence from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 *
 * Example
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 *
 */
public class WordLadder {

    private static class Entry {
        String str;
        int level;
        public Entry(String str, int level) {
            this.str = str;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Deque<Entry> deque = new LinkedList<>();
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        deque.offer(new Entry(beginWord, 1));
        while (!deque.isEmpty()) {
            Entry entry = deque.poll();
            builder.append(entry.str);
            if (set.contains(entry.str)) continue;
            set.add(entry.str);
            for (int index = 0; index < entry.str.length(); index++) {
                builder.replace(0, builder.length(), entry.str);
                for (char charIndex = 'a'; charIndex <= 'z'; charIndex++) {
                    builder.setCharAt(index, charIndex);
                    String currentStr = builder.toString();
                    if (currentStr.equals(endWord)) return entry.level + 1;
                    if (set.contains(currentStr)) continue;
                    if (!wordDict.contains(currentStr)) continue;
                    deque.offer(new Entry(currentStr, entry.level + 1));
                }
            }
            builder.delete(0, builder.length());
        }
        return 0;
    }


}
