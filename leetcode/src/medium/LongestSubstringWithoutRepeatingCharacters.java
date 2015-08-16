package medium;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2015/8/15 14:26
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] conflictTable = new int[128];
        Arrays.fill(conflictTable, Integer.MAX_VALUE);
        int maxLength = 0;
        int start = 0;
        int lastStart = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int conflictIndex = conflictTable[c];
            end++;
            if (conflictIndex != Integer.MAX_VALUE) {
                start = Math.max(lastStart, conflictTable[c]);
                if (chars[start] == c && start < i)
                    start++;
                lastStart = start;
            }
            maxLength = Math.max(maxLength, end - start);
            conflictTable[c] = i;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaaaaaaaaaaa"));
    }

}
