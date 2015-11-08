package medium;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2015/11/8 9:59.
 *
 * Given two array of integers(the first array is array A,
 * the second array is array B),
 * now we are going to find a element in array A which is A[i],
 * and another element in array B which is B[j],
 * so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible,
 * return their smallest difference.
 *
 * Example
 * For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
 *
 * Challenge
 * O(n log n) time
 *
 */
public class TheSmallestDifference {

    private class Pair implements Comparable<Pair> {
        int val;
        boolean belongsA;
        public Pair(int val, boolean belongsA) {
            this.val = val;
            this.belongsA = belongsA;
        }

        @Override
        public int compareTo(Pair o) {return val > o.val ? 1 : val < o.val ? -1 : 0;}
    }
    public int smallestDifference(int[] A, int[] B) {
        Pair[] pairs = new Pair[A.length + B.length];
        int index = 0;
        for (int i : A) pairs[index++] = new Pair(i, true);
        for (int i : B) pairs[index++] = new Pair(i, false);
        Arrays.sort(pairs);
        Pair pre = pairs[0];
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < pairs.length; i++) {
            Pair cur = pairs[i];
            if(pre.belongsA ^ cur.belongsA) minDiff = Math.min(minDiff, Math.abs(pre.val - cur.val));
            pre = cur;
        }
        return minDiff;
    }

}
