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
 * ����������еĶ��壺
 *
 * �������������������һ�����У�ͨ��2�������ҵ�����������У�ע�⣺��ͬ���Ӵ���LCS����Ҫ���������Ӵ������������ǵ���
 * �ļ������ѧ���⣬���ļ�����Ƚϳ���Ļ�������������Ϣѧ��Ҳ����Ӧ�á�
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
