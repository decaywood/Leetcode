package easy;

/**
 * @author: decaywood
 * @date: 2015/10/24 10:08.
 *
 * Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).
 *
 * Example
 * Given x = 123, return 321
 *
 * Given x = -123, return -321
 *
 */
public class ReverseInteger {

    public int reverseInteger(int n) {
        long factor = n < 0 ? -1 : 1;
        n = Math.abs(n);
        long res = 0;
        while (n != 0) {
            res += n % 10;
            res *= 10;
            n /= 10;
        }
        res = (res / 10 > Integer.MAX_VALUE ? 0 : res / 10) * factor;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverseInteger(1534236469));
    }

}
