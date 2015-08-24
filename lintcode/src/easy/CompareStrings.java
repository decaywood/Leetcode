package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/8/24 10:11
 *
 * Compare two strings A and B, determine whether A contains all of the characters in B.
 *
 * The characters in string A and B are all Upper Case letters.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * For A = "ABCD", B = "ACD", return true.
 *
 * For A = "ABCD", B = "AABC", return false.
 *
 * Note
 * The characters of B in A are not necessary continuous or ordered.
 *
 *
 */
public class CompareStrings {

    public boolean compareStrings(String A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : A.toCharArray()) {
            if(!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }

        for (char c : B.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

}
