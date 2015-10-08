package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/30 17:33
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

    Map<Character, char[]> characterMap = new HashMap<>();

    {
        characterMap.put('2', "abc".toCharArray());
        characterMap.put('3', "def".toCharArray());
        characterMap.put('4', "ghi".toCharArray());
        characterMap.put('5', "jkl".toCharArray());
        characterMap.put('6', "mno".toCharArray());
        characterMap.put('7', "pqrs".toCharArray());
        characterMap.put('8', "tuv".toCharArray());
        characterMap.put('9', "wxyz".toCharArray());
    }

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        letterCombinations(res, new StringBuilder(), digits, 0);
        return res;
    }

    public void letterCombinations(List<String> res, StringBuilder builder, String digits, int index) {
        if(index == digits.length()) {
            res.add(builder.toString());
            return;
        }
        for (char letter : characterMap.get(digits.charAt(index))) {
            StringBuilder temp = new StringBuilder(builder);
            temp.append(letter);
            letterCombinations(res, temp, digits, index + 1);
        }
    }

    public static void main(String[] args) {
        new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
    }

}
