package easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/8/22 20:59.
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * The brackets must close in the correct order,
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        Map<Character, Character> characterMap = new HashMap<Character, Character>(){{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Deque<Character> characters = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if(characters.peek() == null || characters.peek() != c) characters.push(characterMap.get(c));
            else characters.pop();
        }
        return characters.isEmpty();
    }

}
