package medium;

/**
 * @author: decaywood
 * @date: 2015/9/29 13:24
 * <p>
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 *
 */
public class LongestPalindromicSubstring {

    private int start = 0, end = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            palindromLen(s, i);
        }
        return s.substring(start + 1, end);
    }

    public void palindromLen(String s, int index) {
        int start1 = index, start2 = index, end1 = index, end2 = index + 1;
        while (start1 >= 0 && end1 < s.length() && s.charAt(start1) == s.charAt(end1)) {
            start1--;
            end1++;
        }
        while (start2 >= 0 && end2 < s.length() && s.charAt(start2) == s.charAt(end2)) {
            start2--;
            end2++;
        }
        if (end1 - start1 > end - start) {
            start = start1;
            end = end1;
        }
        if (end2 - start2 > end - start) {
            start = start2;
            end = end2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("bb"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aababbaabaa"));
    }

}
