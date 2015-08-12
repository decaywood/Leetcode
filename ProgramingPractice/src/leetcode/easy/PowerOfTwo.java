package leetcode.easy;

/**
 * @author: decaywood
 * @date: 2015/7/26 11:38
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
