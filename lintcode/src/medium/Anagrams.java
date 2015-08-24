package medium;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/8/24 10:33
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
 *
 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 *
 * Note
 * All inputs will be in lower-case
 *
 */
public class Anagrams {

    public static List<String> anagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int[] alphabet = new int[26];
        for (String str : strs) {
            int key = 0;
            for (char c : str.toCharArray()) alphabet[c - 'a']++;
            for (int i = 0; i < 26; i++) {
                if(alphabet[i] == 0) continue;
                key += (key * 31 + i) * 31 + alphabet[i];
                alphabet[i] = 0;
            }
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        for (List<String> l : map.values()) {
            if(l.size() < 2) continue;
            list.addAll(l);
        }
        return list;
    }

    public static void main(String[] args) {
        anagrams(new String[]{"lint", "intl", "inlt", "code"});
    }

}
