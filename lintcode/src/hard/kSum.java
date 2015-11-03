package hard;

/**
 * @author: decaywood
 * @date: 2015/10/31 13:34.
 *
 * Given n distinct positive integers, integer k (k <= n) and a number target.
 *
 * Find k numbers where sum is target. Calculate how many solutions there are?
 *
 * Example
 * Given [1,2,3,4], k = 2, target = 5.
 *
 * There are 2 solutions: [1,4] and [2,3].
 *
 * Return 2.
 *
 */
public class kSum {

/*
    public int kSum(int A[], int k, int target) {
        int[] count = new int[1];
        kSum(A, count, 0, k, target);
        return count[0];
    }

    public void kSum(int A[], int[] count, int start, int k, int target) {
        if(k < 0) return;
        if(k == 0 && target == 0) count[0]++;
        for (int i = start; i < A.length; i++) {
            int num = A[i];
            if(target - num < 0) break;
            kSum(A, count, i + 1, k - 1, target - num);
        }
    }*/
}
