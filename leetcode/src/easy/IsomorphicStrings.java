package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/8/14 20:33
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 *
 * Given "foo", "bar", return false.
 *
 * Given "paper", "title", return true.
 *
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> mapStoT = new HashMap<>();
        Map<Character, Character> mapTtoS = new HashMap<>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[] compare = new int[chars1.length];
        for (int i = 0; i < chars1.length; i++) {
            char c1 = chars1[i];
            char c2 = chars2[i];
            mapStoT.putIfAbsent(c1, c2);
            mapTtoS.putIfAbsent(c2, c1);

            if(c1 != mapTtoS.get(c2) || c2 != mapStoT.get(c1)) return false;

        }
        return true;

    }


}
