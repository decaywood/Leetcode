package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/10/26 22:13.
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *
 * For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Challenge
 * O(n) time
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = s.length() == 0 ? 0 : 1;
        int start = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) start = Math.max(start, map.get(c));
            map.put(c, i);
            maxLen = Math.max(maxLen, i - start);
        }
        return maxLen;
    }


}
