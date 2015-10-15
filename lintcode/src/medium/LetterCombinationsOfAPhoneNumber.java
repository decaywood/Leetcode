package medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/10/15 20:53.
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Cellphone
 *
 * Example
 * Given "23"
 *
 * Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *
 * Note
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterCombinationsOfAPhoneNumber {

    public ArrayList<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        ArrayList<String> res = new ArrayList<>();
        analizeLetter(map, res, new StringBuilder(), digits, 0);
        return res;
    }


    private void analizeLetter(Map<Character, String> map, List<String> list, StringBuilder builder, String digits, int index) {
        if(digits.length() == index) {
            list.add(builder.toString());
            return;
        }

        for (char c : map.get(digits.charAt(index)).toCharArray()) {
            StringBuilder temp = new StringBuilder(builder);
            temp.append(c);
            analizeLetter(map, list, temp, digits, index + 1);
        }

    }

}
