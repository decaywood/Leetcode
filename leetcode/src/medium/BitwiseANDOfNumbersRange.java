package medium;

/**
 * @author: decaywood
 * @date: 2015/10/1 17:25
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 *
 * 我们先从题目中给的例子来分析，[5, 7]里共有三个数字，分别写出它们的二进制为：
 * 101　　110　　111
 * 相与后的结果为100，仔细观察我们可以得出，最后的数是该数字范围内所有的数的左边共同的部分，
 * 如果上面那个例子不太明显，我们再来看一个范围[26, 30]，它们的二进制如下：
 * 11010　　11011　　11100　　11101　　11110
 * 发现了规律后，我们只要写代码找到左边公共的部分即可
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
