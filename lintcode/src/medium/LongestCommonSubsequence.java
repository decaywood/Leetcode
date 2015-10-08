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
        int res = 0;
        int[][] dp = new int[B.length()][A.length()];
        for (int i = 0; i < A.length(); i++)
            dp[0][i] = B.charAt(0) == A.charAt(i) ? 1 : 0;

        for (int i = 1; i < B.length(); i++) {
            int val = 0;
            for (int j = 0; j < A.length(); j++) {
                dp[i][j] = B.charAt(i) == A.charAt(j) ? val + 1 : dp[i - 1][j];
                val = Math.max(val, dp[i - 1][j]);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

}
