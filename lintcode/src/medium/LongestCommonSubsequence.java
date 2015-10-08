package medium;

/**
 * @author: decaywood
 * @date: 2015/10/8 16:18
 *
 * Given two strings, find the longest common subsequence (LCS).
 * Your code should return the length of LCS.
 *
 * Example
 * For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 * For "ABCD" and "EACB", the LCS is "AC", return 2.
 *
 * Clarification
 * What's the definition of Longest Common Subsequence?
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * http://baike.baidu.com/view/2020307.htm
 *
 * 最长公共子序列的定义：
 *
 * 最长公共子序列问题是在一组序列（通常2个）中找到最长公共子序列（注意：不同于子串，LCS不需要是连续的子串）。该问题是典型
 * 的计算机科学问题，是文件差异比较程序的基础，在生物信息学中也有所应用。
 *
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String A, String B) {
        String longStr = A.length() > B.length() ? A : B;
        String shortStr = A.equals(longStr) ? B : A;
        int[] dp = new int[longStr.length() + 1];
        for (int i = 0; i < longStr.length(); i++)
            dp[i] = shortStr.charAt(0) == longStr.charAt(0) ? 1 : 0;

        for (int i = 1; i < shortStr.length(); i++) {
            char preShortC = shortStr.charAt(i - 1);
            char shortC = shortStr.charAt(i);
            for (int j = 1; j < longStr.length(); j++) {
                char longC = longStr.charAt(j - 1);
                if(longC == preShortC)
                dp[j] = longC == shortC ? dp[j - 1] + 1 : dp[j];
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        new LongestCommonSubsequence().longestCommonSubsequence("BCACBDCAABA", "BCBDACBDCA");
    }
}
