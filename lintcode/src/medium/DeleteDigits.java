package medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/9/1 13:04
 *
 * Given string A representative a positive integer which has N digits,
 * remove any k digits of the number, the remaining digits are arranged
 * according to the original order to become a new positive integer.
 *
 * Find the smallest integer after remove k digits.
 *
 * N <= 240 and k <= N,
 *
 * Example
 * Given an integer A = "178542", k = 4
 *
 * return a string "12"
 *
 */
public class DeleteDigits {


    public static String DeleteDigits(String A, int k) {
        Deque<Character> characters = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if(!characters.isEmpty())
                while (k > 0 && !characters.isEmpty() && characters.peek() > c) {
                    characters.pop();
                    k--;
                }
            characters.push(c);
        }
        while (k > 0) {
            characters.pollFirst();
            k--;
        }
        while (characters.peekLast() == '0' && characters.size() > 1) characters.pollLast();
        while (!characters.isEmpty()) builder.append(characters.pollLast());
        return builder.toString();
    }

}
