package easy;

/**
 * @author: decaywood
 * @date: 2016/4/23 15:42.
 */
public class PowerOfFour {

    private static int mask = Integer.parseInt("1010101010101010101010101010101", 2);
    public static boolean isPowerOfFour(int num) {
        return num != 0 && (num & mask) == num && (num & (num - 1)) == 0;
    }
}
