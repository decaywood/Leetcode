package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: decaywood
 * @date: 2015/10/7 13:46.
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * patterncontains only lowercase alphabetical letters, and str contains words separated by a single space. Each word in str contains only lowercase alphabetical letters.
 * Both pattern and str do not have leading or trailing spaces.
 * Each letter in pattern must map to a word with length that is at least 1.
 *
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        int[] hashTable = new int[26];
        String[] dict = str.split("\\s");
        if(pattern.length() != dict.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'a';
            int hash = dict[i].hashCode();
            hashTable[index] = hashTable[index] == 0 ? hash : hashTable[index];
            if(hashTable[index] != hash) return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : hashTable) {
            if(i != 0 && set.contains(i)) return false;
            set.add(i);
        }
        return true;
    }


}
