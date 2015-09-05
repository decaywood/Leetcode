package medium;

/**
 * @author: decaywood
 * @date: 2015/8/24 11:32
 *
 * Given two strings, find the longest common substring.
 *
 * Return the length of it.
 *
 * Example
 * Given A = "ABCD", B = "CBCE", return 2.
 *
 * Note
 * The characters in substring should occur continuously in original string.
 * This is different with subsequence.
 *
 * Challenge
 * O(n x m) time and memory.
 *
 * 思路：利用动态规划
 */
public class LongestCommonSubstring {

    public static int longestCommonSubstring(String A, String B) {
        if(A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
        int maxLength = 0;
        char[] longStr = (A.length() > B.length() ? A : B).toCharArray();
        char[] shortStr = (A.length() <= B.length() ? A : B).toCharArray();
        int[][] dp = new int[shortStr.length][];
        for (int i = 0; i < shortStr.length; i++) {
            dp[i] = new int[longStr.length];
        }
        for (int i = 0; i < longStr.length; i++) {
            dp[0][i] = shortStr[0] == longStr[i] ? 1 : 0;
            maxLength = Math.max(maxLength, dp[0][i]);
        }
        for (int i = 1; i < shortStr.length; i++) {
            for (int j = 1; j < longStr.length; j++) {
                if(shortStr[i] == longStr[j])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }


}
