package medium;

/**
 * @author: decaywood
 * @date: 2015/8/31 16:31
 *
 * Calculate the a^n % b where a, b and n are all 32bit integers.
 *
 * Example
 * For 2^31 % 3 = 2
 *
 * For 1001000 % 1000 = 0
 *
 * Challenge
 * O(logn)
 */
public class FastPower {

    public static int fastPower(int a, int b, int n) {
        if (n == 0) return 1 % b;
        return fastPowerRecur(a, b, n);
    }


    public static int fastPowerRecur(int a, int b, int n) {
        if (n == 1) return a % b;
        long temp = fastPowerRecur(a, b, n / 2);
        temp = temp * temp % b;
        return (n % 2 == 0) ? (int) temp : (int) (temp * a % b);
    }


    public static void main(String[] args) {
        System.out.println(fastPower(2, 3, 31));
    }


}
