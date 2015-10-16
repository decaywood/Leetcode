package easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/10/16 14:21
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class ValidParentheses {

    public boolean isValidParentheses(String s) {
        Deque<Character> stack = new LinkedList<>();
        stack.push('#');
        for (char c : s.toCharArray()) {
            if(stack.peek() == get(c)) stack.pop();
            else stack.push(c);
        }
        return stack.size() == 1;
    }

    private Character get(char c) {
        switch (c) {
            case '}' : return '{';
            case ']' : return '[';
            case ')' : return '(';
        }
        return '*';
    }

}
