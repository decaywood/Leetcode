package easy;

/**
 * @author: decaywood
 * @date: 2015/8/28 14:02
 *
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 *
 * Example
 * 11! = 39916800, so the out should be 2
 *
 * Challenge
 * O(log N) time
 *
 * 思路：零的个数直接取决于阶乘中5的个数（包括5的倍数, 注意25包含两个5，125包含三个5....以此类推）
 *
 * count = floor(n/5) + floor(n/25) + floor(n/125) + ....
 *
 */
public class TrailingZeros {

    public long trailingZeros(long n) {
        long count = 0;
        for (long divisor = 5; n/divisor >= 1; divisor *= 5) count += n / divisor;
        return count;
    }

}
