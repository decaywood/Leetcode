package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/10/16 17:10
 *
 * Find the Nth number in Fibonacci sequence.
 *
 * A Fibonacci sequence is defined as follow:
 *
 * The first two numbers are 0 and 1.
 * The i th number is the sum of i-1 th number and i-2 th number.
 * The first ten numbers in Fibonacci sequence is:
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given 1, return 0
 *
 * Given 2, return 1
 *
 * Given 10, return 34
 *
 * Note
 * The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.
 *
 */
public class Fibonacci {

    public int fibonacci(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return fibonacci(map, n);
    }

    public int fibonacci(Map<Integer, Integer> map, int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(map.containsKey(n)) return map.get(n);
        int res = fibonacci(map, n - 1) + fibonacci(map, n - 2);
        map.put(n, res);
        return res;
    }


}
