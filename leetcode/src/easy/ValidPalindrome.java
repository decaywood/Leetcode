package easy;

/**
 * @author: decaywood
 * @date: 2015/8/20 20:30
 *
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        char[] chars = s.toLowerCase().toCharArray();
        for (int left = 0, right = chars.length - 1; left < right; left++, right--) {
            while (isLegal(chars[left]) && left < right) left++;
            while (isLegal(chars[right]) && left < right) right--;
            if(chars[left] != chars[right]) return false;
        }
        return true;
    }

    private static boolean isLegal(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
        isPalindrome("aa");
    }

}
