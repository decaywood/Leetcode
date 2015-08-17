package easy;

/**
 * @author: decaywood
 * @date: 2015/8/17 20:07.
 *
 * Determine whether an integer is a palindrome.
 * Do this without extra space.
 *
 */
public class PalindromeNumber {
/* 此方法用了额外的内存空间
    public static boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        for (int head = 0, tail = chars.length - 1; head <= tail; head++, tail--) if(chars[head] != chars[tail]) return false;
        return true;
    }

    */

    /**
     * 用y存储x右半边低位的数
     */
    public static boolean isPalindrome(int x) {
        int lowBit = 0, highBit = x;
        while (x > 0) {
            lowBit = lowBit*10 + x%10;
            x /= 10;
        }
        return highBit == lowBit;
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome(11));
    }
}
