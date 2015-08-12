package leetcode.easy;

public class MergeSortedArray {

    /**
     * Given two sorted integer arrays A and B, merge B into A as one sorted
     * array.
     * 
     * Note: You may assume that A has enough space (size that is greater or
     * equal to m + n) to hold additional elements from B. The number of
     * elements initialized in A and B are m and n respectively.
     */
    
    public void merge(int A[], int m, int B[], int n) {
        int length = A.length -1;
        for(int offsetA = m-1, offsetB = n-1; length >= 0;){
            if(offsetA < 0){
                A[length--] = B[offsetB--];
                continue;
            }
            if(offsetB < 0){
                A[length--] = A[offsetA--];
                continue;
            }
            if(B[offsetB] > A[offsetA])
                A[length--] = B[offsetB--];
            else {
                A[length--] = A[offsetA--];
            }
        }
    }
}
