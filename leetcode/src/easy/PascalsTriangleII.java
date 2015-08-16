package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author: decaywood
 * @date: 2015/8/15 20:47
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {


    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        IntStream.range(0, rowIndex + 1).forEach(x -> result.add(nChooseK(rowIndex, x)));
        return result;
    }

    /**
     * C(n, k) = C(n, k+1) * ((n - k + 1) / k)
     */
    private static int nChooseK(long n, long k) {
        if(k == 0) return 1;
        return (int) (nChooseK(n, k-1) * (n-k+1) / k);
    }

  /*

      private static int combination(int n, int k) {

        BigInteger numerator = IntStream.range(n - k + 1, n + 1).mapToObj(x -> new BigInteger(String.valueOf(x))).reduce(new BigInteger("1"), BigInteger::multiply);
        BigInteger denominator = IntStream.range(1, k + 1).mapToObj(x -> new BigInteger(String.valueOf(x))).reduce(new BigInteger("1"), BigInteger::multiply);
        return numerator.divide(denominator).intValue();

      }

  */

    public static void main(String[] args) {
//        getRow(13);
        System.out.println(nChooseK(26, 13));
    }
}
