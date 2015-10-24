package medium;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/10/24 10:26.
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code,
 * find the sequence of gray code. A gray code sequence must begin with 0 and with cover all 2n integers.
 *
 * Example
 * Given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note
 * For a given n, a gray code sequence is not uniquely defined.
 *
 * [0,2,3,1] is also a valid gray code sequence according to the above definition.
 *
 * Challenge
 * O(2n) time.
 *
 */
public class GrayCode {

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        //Based formula: G(n) = n ^ (n>>1)
        for (int i = 0; i < 1 << n; i++) res.add(i ^ (i >> 1));
        return res;
    }

}
