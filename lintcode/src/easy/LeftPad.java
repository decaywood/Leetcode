package easy;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2016/4/24 13:01.
 * <p>
 * You know what, left pad is javascript package and referenced by React:
 * Github link
 * <p>
 * One day his author unpublished it, then a lot of javascript projects in the world broken.
 * <p>
 * You can see from github it's only 11 lines.
 * <p>
 * You job is to implement the left pad function. If you do not know what left pad does, see examples below and guess.
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * leftpad("foo", 5)
 * >> "  foo"
 * <p>
 * leftpad("foobar", 6)
 * >> "foobar"
 * <p>
 * leftpad("1", 2, "0")
 * >> "01"
 *
 */
public class LeftPad {

    static public String leftPad(String originalStr, int size) {
        return leftPad(originalStr, size, ' ');
    }

    static public String leftPad(String originalStr, int size, char padChar) {
        char[] chars = new char[Math.max(originalStr.length(), size)];
        Arrays.fill(chars, padChar);
        for (int i = chars.length - 1, j = originalStr.length() - 1; j >= 0; i--,j--) {
            chars[i] = originalStr.charAt(j);
        }
        return new String(chars);
    }

}
