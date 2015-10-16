package easy;

/**
 * @author: decaywood
 * @date: 2015/10/16 15:47
 *
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 *
 * Example
 * "A man, a plan, a canal: Panama" is a palindrome.
 *
 * "race a car" is not a palindrome.
 *
 * Note
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Challenge
 * O(n) time without extra memory.
 *
 */
public class ValidPalindrome {

        public boolean isPalindrome(String s) {
            StringBuilder builder = new StringBuilder();
            for (char c : s.toCharArray()) if(isAlphabetic(c)) builder.append(c);
            s = builder.toString();
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) return false;
            }
            return true;
        }

        private boolean isAlphabetic(char c) {
            return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
        }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
