package medium;

/**
 * @author: decaywood
 * @date: 2015/9/28 16:24
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 */
public class SqrtX {

    public int mySqrt(int x) {
        return x == 0 ? 0 : findRes(1, x, x);
    }

    private int findRes(int x, int y, int val) {
        if(x + 1 >= y) return val / x / x == 0 ? y : x;
        int mid = x + (y - x) / 2;
        return val / mid /mid == 0 ? findRes(x, mid, val) : findRes(mid, y, val);
    }

}
