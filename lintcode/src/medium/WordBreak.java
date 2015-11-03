package medium;

import java.util.Set;

/**
 * @author: decaywood
 * @date: 2015/9/14 16:58
 *
 * Given a string s and a dictionary of words dict,
 * determine if s can be break into a space-separated sequence of one or more dictionary words.
 *
 * Example
 * Given s = "lintcode", dict = ["lint", "code"].
 *
 * Return true because "lintcode" can be break as "lint code".
 *
 */

public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canContinue = new boolean[s.length() + 1];
        canContinue[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if(!canContinue[i]) continue;
            for (String str : dict) {
                if(i + str.length() <= s.length() && s.substring(i, i + str.length()).equals(str)){
                    canContinue[i + str.length()] = true;
                }
            }
        }
        return canContinue[s.length()];
    }


}
