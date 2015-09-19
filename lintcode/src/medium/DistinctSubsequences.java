package medium;

/**
 * @author: decaywood
 * @date: 2015/9/14 15:25
 *
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative
 * positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example
 * Given S = "rabbbit", T = "rabbit", return 3.
 *
 * Challenge
 * Do it in O(n2) time and O(n) memory.
 *
 * O(n2) memory is also acceptable if you do not know how to optimize memory.
 *
 */
public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
        if(S==null||T==null) return 0;
        if(S.length()<T.length()) return 0;
        int [][] dp = new int[S.length()+1][T.length()+1];
        for(int i=0;i<S.length();i++) dp[i][0] = 1;
        for(int i=1;i<=S.length();i++) {
            for(int j=1;j<=T.length();j++) {
                //如果S和T的当前字符相等，那么有两种选法；否则S的当前字符不能要
                dp[i][j] = dp[i-1][j];
                if(S.charAt(i-1)==T.charAt(j-1)) dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[S.length()][T.length()];
    }

}
