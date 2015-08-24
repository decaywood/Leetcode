package medium;

/**
 * @author: decaywood
 * @date: 2015/8/24 13:36
 *
 * Given k strings, find the longest common prefix (LCP).
 *
 * Have you met this question in a real interview? Yes
 * Example
 * For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"
 *
 * For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
 *
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int count = 0;
        char[][] strArray = new char[strs.length][];
        int minStrLength = Integer.MAX_VALUE;
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strs[i].toCharArray();
            minStrLength = Math.min(minStrLength, strArray[i].length);
        }
        for (int i = 0; i < minStrLength; i++) {
            char c = strArray[0][i];
            for (int j = 1; j < strArray.length; j++) {
                if (strArray[j][i] != c) return strs[0].substring(0, count);
            }
            count++;
        }
        return strs[0].substring(0, count);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{}));
    }

}
