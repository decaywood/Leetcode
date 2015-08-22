package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: decaywood
 * @date: 2015/8/21 16:41
 *
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {


    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return doTest(set, n);
    }

    public static boolean doTest(Set<Integer> set, int n) {
        if(set.contains(n)) return false;
        set.add(n);
        int squares = 0;
        while (n > 0) {
            int num = n % 10;
            n /= 10;
            squares += num * num;
        }
        return squares == 1 || doTest(set, squares);
    }


}
