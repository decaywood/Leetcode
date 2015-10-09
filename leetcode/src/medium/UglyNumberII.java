package medium;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/10/9 19:36.
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example,
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * Note that 1 is typically treated as an ugly number.
 *
 * Hint:
 *
 * The naive approach is to call isUgly for every number until you reach the nth one.
 * Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
 * An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 * The key is how to maintain the order of the ugly numbers.
 * Try a similar approach of merging from three sorted lists: L1, L2, and L3.
 * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 *
 */
public class UglyNumberII {

/*

   public int nthUglyNumber(int n) {

        if(n==1) return 1;

        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);

        for(long i=1; i<n; i++) {
            long val = queue.poll();
            while(!queue.isEmpty() && queue.peek()==val) val = queue.poll();

            queue.add(val * 2);
            queue.add(val * 3);
            queue.add(val * 5);
        }
        return queue.poll().intValue();
    }

*/

    public int nthUglyNumber(int n) {

        int val = 0;

        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        List<Integer> l3 = new LinkedList<>();

        l1.add(1);
        l2.add(1);
        l3.add(1);

        for(int i=0; i<n; i++) {
            val = Math.min( Math.min(l1.get(0), l2.get(0)), l3.get(0));

            if(l1.get(0) == val) l1.remove(0);
            if(l2.get(0) == val) l2.remove(0);
            if(l3.get(0) == val) l3.remove(0);

            l1.add(val*2);
            l2.add(val*3);
            l3.add(val*5);
        }
        return val;
    }



    public static void main(String[] args) {
            System.out.println(1407 + " - " + new UglyNumberII().nthUglyNumber(1407));
    }
}
