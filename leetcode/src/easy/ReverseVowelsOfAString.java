package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: decaywood
 * @date: 2016/4/23 15:12.
 * <p>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 */
public class ReverseVowelsOfAString {

    private static Set<Character> vowels = new HashSet<>();

    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }

    public static String reverseVowels(String s) {
        if (s == null) return null;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0, j = s.length() - 1;i <= j;) {
            char v1 = s.charAt(i);
            char v2 = s.charAt(j);
            if (vowels.contains(v1) && vowels.contains(v2)) {
                sb.setCharAt(i, v2);
                sb.setCharAt(j, v1);
                i++;
                j--;
            }
            if (!vowels.contains(v1)) i++;
            if (!vowels.contains(v2)) j--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

}
