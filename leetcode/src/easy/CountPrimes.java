package easy;

/**
 * @author: decaywood
 * @date: 2015/9/30 17:05
 *
 * Description:
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Hint:
 *
 * Let's start with a isPrime function.
 * To determine if a number is prime,
 * we need to check if it is not divisible by any number less than n.
 * The runtime complexity of isPrime function would be O(n)
 * and hence counting the total prime numbers up to n would be O(n2).
 * Could we do better?
 *
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        boolean[] dp = new boolean[n];
        for (int i = 2; i < n; i++) {
            if(dp[i]) continue;
            count++;
            for (int j = i; j < n; j += i)
                dp[j] = true;
        }
        return count;
    }

}
