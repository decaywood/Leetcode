package easy;

/**
 * @author: decaywood
 * @date: 2015/8/16 21:16
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * For example:
 *
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * 找出规律即可，若需要结果只有一位数，很明显跟9的余数有关
 */
public class AddDigits {

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

}
