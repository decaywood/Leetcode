package easy;

/**
 * @author: decaywood
 * @date: 2015/8/28 11:06
 *
 * Determine the number of bits required to flip if you want to convert integer n to integer m.
 *
 * Example
 * Given n = 31 (11111), m = 14 (01110), return 2.
 *
 * Note
 * Both n and m are 32-bit integers.
 *
 */
public class FlipBits {

    public static int bitSwapRequired(int a, int b) {
        int change = a ^ b;
        return countBits(change);
    }

    private static int countBits(int a) {
        int count = 0;
        while (a != 0) {
            a = a & (a - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        countBits(120412512);
    }
}
