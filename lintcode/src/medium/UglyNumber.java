package medium;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author: decaywood
 * @date: 2015/10/10 11:30
 *
 * Ugly number is a number that only have factors 3, 5 and 7.
 *
 * Design an algorithm to find the Kth ugly number. The first 5 ugly numbers are 3, 5, 7, 9, 15 ...
 *
 * Have you met this question in a real interview? Yes
 * Example
 * If K=4, return 9.
 *
 * Challenge
 * O(K log K) or O(K) time.
 *
 */
public class UglyNumber {

    public long kthPrimeNumber(int k) {

        Queue<Long> l1 = new LinkedList<>();
        Queue<Long> l2 = new LinkedList<>();
        Queue<Long> l3 = new LinkedList<>();
        l1.offer(1L);
        l2.offer(1L);
        l3.offer(1L);

        long res = 0;
        while (k + 1 != 0) {

            long min = Math.min(l1.peek(), Math.min(l2.peek(), l3.peek()));

            if(l1.peek() == min) l1.poll();
            if(l2.peek() == min) l2.poll();
            if(l3.peek() == min) l3.poll();

            l1.offer(min * 3);
            l2.offer(min * 5);
            l3.offer(min * 7);

            res = min;
            k--;
        }

        return res;
    }




}
