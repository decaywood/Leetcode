package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
    /**
     * Given a string s and a dictionary of words dict, add spaces in s to
     * construct a sentence where each word is a valid dictionary word.
     * 
     * Return all such possible sentences.
     * 
     * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
     * 
     * A solution is ["cats and dog", "cat sand dog"].
     */
    
//    public List<String> wordBreak(String s, Set<String> dict) {
//        List<String> res = new ArrayList<String>();
//        if(s==null || s.length()==0)
//            return res;
//        helper(s,dict,0,"",res);
//        return res;
//    }
//    private void helper(String s, Set<String> dict, int start, String item, List<String> res)
//    {
//        if(start>=s.length())  //当扫描完整个s时，则已经合并成一个完整组合
//        {
//            res.add(item);
//            return;
//        }
//        StringBuilder str = new StringBuilder();
//        for(int i=start;i<s.length();i++)
//        {
//            str.append(s.charAt(i));
//            if(dict.contains(str.toString()))
//            {
//                String newItem = item.length()>0?(item+" "+str.toString()):str.toString();
//                helper(s,dict,i+1,newItem,res);
//            }
//        }
//    }
}
