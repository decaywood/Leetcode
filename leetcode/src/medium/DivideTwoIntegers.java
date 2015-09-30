package medium;

/**
 * @author: decaywood
 * @date: 2015/9/29 16:04
 *
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 *
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        int minus = (dividend < 0 ? -1 : 1) * (divisor < 0 ? -1 : 1);
        if(dividend == Integer.MIN_VALUE && divisor == -1) return ~dividend;
        long res = 0;
        long factor = 1;
        long divisorTmp = Math.abs((long) divisor);
        long dividendTmp = Math.abs((long) dividend);
        while (dividendTmp > 0) {
            for (; divisorTmp << 1 <= dividendTmp; ) {
                factor <<= 1;
                divisorTmp <<= 1;
            }
            dividendTmp -= divisorTmp;
            divisorTmp = Math.abs(divisor);
            res += factor;
            factor = 1;
        }
        return (int) ((res - (dividendTmp == 0 ? 0 : 1)) * minus);
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(0, -1));
    }
}
