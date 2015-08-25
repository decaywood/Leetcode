package easy;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2015/8/24 18:49
 *
 *
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Example
 * A = [1, 2, 3, empty, empty], B = [4, 5]
 *
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 *
 * Note
 * You may assume that A has enough space
 * (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 *
 *
 */
public class MergeSortedArray {

    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if(B.length == 0) return;
        int[] copyA = Arrays.copyOf(A, m);
        for (int indexA = 0, indexB = 0; indexA + indexB < m + n;) {
            int val;
            if (indexA == m || indexB < n && B[indexB] < copyA[indexA]) val = B[indexB++];
            else val = copyA[indexA++];
            A[indexA + indexB - 1] = val;
        }
    }

    public static void main(String[] args) {
        mergeSortedArray(new int[]{1, 2, 3, 0, 0}, 3, new int[]{4, 5},2);


    }
}
