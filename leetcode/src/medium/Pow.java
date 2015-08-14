package src.medium;

/**
 * @author: decaywood
 * @date: 2015/8/12 9:13
 *
 * Implement pow(x, n).
 *
 */
public class Pow {

    public double myPow(double x, int n) {
        if(Math.abs(x) == 1) return n % 2 == 0 ? 1 : x;
        if(n < 0) return 1 / doMyPow(x, -n);
        if(n == 0) return 1;
        return doMyPow(x, n);
    }
    private static double doMyPow(double x, int index) {
        double remain = 1;
        while (index != 1) {
            double r = x;
            x = x * x;
            boolean hasRemain = index % 2 == 1;
            remain = remain * (hasRemain ? r : 1);
            index >>= 1;
        }
        return x * remain;
    }

    public static void main(String[] args) {
        System.out.println(doMyPow(-3, 2));
    }
}
