package easy;

/**
 * @author: decaywood
 * @date: 2015/10/31 14:42.
 *
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Example
 * Clarification
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 *
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            String str = strings[i];
            builder.append(str.trim()).append(" ");
        }
        return builder.toString().trim();
    }

}
