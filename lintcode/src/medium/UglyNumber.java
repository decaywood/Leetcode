package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: decaywood
 * @date: 2015/10/10 20:31.
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


    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(new UglyNumber().kthPrimeNumber(i));
        }
    }

}
