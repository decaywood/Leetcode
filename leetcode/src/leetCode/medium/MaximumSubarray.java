package leetCode.medium;

public class MaximumSubarray {

    /**
     * Find the contiguous subarray within an array (containing at least one
     * number) which has the largest sum.
     * 
     * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
     * subarray [4,−1,2,1] has the largest sum = 6.
     * 
     * click to show more practice.
     * 
     * More practice: If you have figured out the O(n) solution, try coding
     * another solution using the divide and conquer approach, which is more
     * subtle
     */
    
    public int maxSubArray(int[] A) {
        
        int max = Integer.MIN_VALUE;
        int tempMax = Integer.MIN_VALUE/2;
        for(int i = 0; i < A.length; i++){
            int temp = tempMax + A[i];
            tempMax = Math.max(temp, A[i]);
            max = Math.max(max, tempMax);
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println( new MaximumSubarray().maxSubArray(new int[]{1, -1, 1}));
    }
}
