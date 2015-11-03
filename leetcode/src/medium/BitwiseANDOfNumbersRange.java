package medium;

/**
 * @author: decaywood
 * @date: 2015/10/1 17:25
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 *
 */
public class BitwiseANDOfNumbersRange {

   /* public int rangeBitwiseAnd(int m, int n) {
        int res = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            res &= i;
        }
        return res;
    }*/

    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++i;
        }
        return (m << i);
    }


}
