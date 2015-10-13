package medium;

/**
 * @author: decaywood
 * @date: 2015/10/9 9:29
 *
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example
 * For s1 = "aabcc", s2 = "dbbca"
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * Challenge
 * O(n2) time or better
 *
 * ˼·�������������ϰ��߸���˼·���ƣ�dp����Ϊint���󣬺�������Ϊ
 * s1��s2��ĸ���У�����s3�����ϵ����£�����val��ʾs3��ǰindex��0��ʾû����һ����
 *
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s3.length() == 0) return true;
        s1 = "#" + s1;
        s2 = "#" + s2;
        s3 = "#" + s3;
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 1; i < s2.length(); i++) {
            dp[0][i] = s2.charAt(i) == s3.charAt(i) ? i : 0;
            if(dp[0][i] == 0) break;
        }
        for (int i = 1; i < s1.length(); i++) {
            dp[i][0] = s1.charAt(i) == s3.charAt(i) ? i : 0;
            if(dp[i][0] == 0) break;
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (dp[i][j - 1] != 0 && s2.charAt(j) == s3.charAt(dp[i][j - 1] + 1)) {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
                if (dp[i - 1][j] != 0 && s1.charAt(i) == s3.charAt(dp[i - 1][j] + 1)) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
        return dp[s1.length() - 1][s2.length() - 1] != 0;
    }


}
