package easy;

/**
 * @author: decaywood
 * @date: 2016/01/29 14:03
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 * Credits:
 * Special thanks to @dietpepsi for adding this problem and creating all test cases.
 *
 * Subscribe to see which companies asked this question
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        return n >= 1 && (1162261467 % n == 0);
    }
}
