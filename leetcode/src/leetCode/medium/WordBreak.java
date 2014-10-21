package leetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    /**
     * Given a string s and a dictionary of words dict, determine if s can be
     * segmented into a space-separated sequence of one or more dictionary
     * words.
     * 
     * For example, given s = "leetcode", dict = ["leet", "code"].
     * 
     * Return true because "leetcode" can be segmented as "leet code"
     */
    
    
    
    public boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true; //强制第一个要检查，否则不会有下面的判断
        for(int i = 0; i < length; i++){
            if(!dp[i]) //只检查s中已匹配前缀后面未检查的字符串s.subString(checkedWord.length())
                continue;
            for(String word : dict){
                if(s.substring(i).startsWith(word))  //例如 s = "abecdsadsaw" 出现word: abecds 则 不再匹配 abecds之前的子串
                    dp[i + word.length()] = true;
            }
        }
        return dp[length];
    }
    
    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("b");
        new WordBreak().wordBreak("ab", dict);
    }
}
