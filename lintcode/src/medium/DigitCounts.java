package medium;

/**
 * @author: decaywood
 * @date: 2015/11/3 12:35
 *
 * Count the number of k's between 0 and n. k can be 0 - 9.
 *
 * Example
 * if n=12, k=1 in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], we have FIVE 1's (1, 10, 11, 12)
 *
 */
public class DigitCounts {


    public int digitCounts(int k, int n) {
        int count = k == 0 ? 1 : 0;
        for (int i = 0; i <= n; i++) {
            count += contains(i, k);
        }
        return count;
    }

    private int contains(int num, int k) {
        int count = 0;
        while (num != 0) {
            if(k == num % 10) count++;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        new DigitCounts().digitCounts(0, 99);
    }
}
