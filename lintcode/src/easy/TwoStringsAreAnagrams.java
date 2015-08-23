package easy;

/**
 * @author: decaywood
 * @date: 2015/8/23 16:10.
 *
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given s="abcd", t="dcab", return true.
 *
 * Challenge
 * O(n) time, O(1) extra space
 *
 */
public class TwoStringsAreAnagrams {

    public boolean anagram(String s, String t) {
        if(s.length() != t.length()) return false;
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
            sum -= t.charAt(i);
        }
        return sum == 0;
    }

}
