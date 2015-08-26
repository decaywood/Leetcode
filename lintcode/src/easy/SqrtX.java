package easy;

/**
 * @author: decaywood
 * @date: 2015/8/26 15:12
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * Example
 * sqrt(3) = 1
 *
 * sqrt(4) = 2
 *
 * sqrt(5) = 2
 *
 * sqrt(10) = 3
 *
 * Challenge
 * O(log(x))
 *
 */
public class SqrtX {

    public static int sqrt(int x) {
        return (int)findX(0, x, x);
    }

    private static long findX(long i, long j, int x) {
        long middle = (i + j) / 2;
        if(i + 1 == j || i + 2 == j) return j * j > x ? middle * middle > x ? i : middle : j;
        if(middle * middle > x) return findX(i, middle, x);
        else if(middle * middle < x) return findX(middle, j, x);
        else return middle;
    }



}
