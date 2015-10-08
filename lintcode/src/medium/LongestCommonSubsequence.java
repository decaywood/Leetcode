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
