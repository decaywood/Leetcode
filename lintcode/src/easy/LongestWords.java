package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/8/23 10:31.
 *
 * Given a dictionary, find all of the longest words in the dictionary.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given
 *
 * {
 * "dog",
 * "google",
 * "facebook",
 * "internationalization",
 * "blabla"
 * }
 * the longest words are(is) ["internationalization"].
 *
 * Given
 *
 * {
 * "like",
 * "love",
 * "hate",
 * "yes"
 * }
 * the longest words are ["like", "love", "hate"].
 *
 * Challenge
 * It's easy to solve it in two passes, can you do it in one pass?
 *
 */
public class LongestWords {

    ArrayList<String> longestWords(String[] dictionary) {
        Map<Integer, ArrayList<String>> stringMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        for (String str : dictionary) {
            if(!stringMap.containsKey(str.length())) stringMap.putIfAbsent(str.length(), new ArrayList<String>());
            stringMap.get(str.length()).add(str);
            maxLength = Math.max(str.length(), maxLength);
        }
        return stringMap.get(maxLength);
    }


}
