package leetcode.medium;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/8/12 9:58
 *
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 *
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 * Note:
 * For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 *
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> listHashMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int[] map = new int[26];
        for (String str : strs) {
            int strHash = 0;
            char[] chars = str.toCharArray();
            //calculate char occurrence time
            for (int index : chars) map[index - 'a']++;
            //calculate hashcode
            for (int index = 0; index < map.length; index++) {
                int time = map[index];
                map[index] = 0;
                strHash += time * index;
            }
            if(listHashMap.containsKey(strHash)) listHashMap.get(strHash).add(str);
            else {
                List<String> list = new LinkedList<>();
                list.add(str);
                result.add(list);
                listHashMap.put(strHash, list);
            }
        }
        result.forEach(x -> x.sort(Comparator.naturalOrder()));
        return result;
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"a"});
    }

}
