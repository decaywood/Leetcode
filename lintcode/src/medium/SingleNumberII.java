package medium;

/**
 * @author: decaywood
 * @date: 2015/9/1 22:20.
 *
 * Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.
 *
 * Example
 * Given [1,1,2,3,3,3,2,2,4,1] return 4
 *
 * Challenge
 * One-pass, constant extra space.
 */
public class SingleNumberII {

    public int singleNumberII(int[] A) {
        int one = 0, two = 0, three;
        for (int i = 0; i < A.length; i++) {
            three = two & A[i]; //已经出现了两次，还出现了一次
            two = two | one & A[i]; //出现了1次又出现了1次，在加上以前已经出现了2次的，为新的出现了2次的
            one = one | A[i]; //出现了1次
            one = one & ~three; //将出现3次的其出现1次2次全部抹去
            two = two & ~three;
        }
        return one;
    }
}
