package medium;


public class MaximumProductSubarray {
    
    /*
     * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
     *
     * For example, given the array [2,3,-2,4],
     * the contiguous subarray [2,3] has the largest product = 6.
     * 
     * 
     */
    
    public static int maxProduct(int[] A) {
        if(A == null){
            return -1;
        }
        int min = A[0];
        int max = A[0];
        int answer = A[0];
        for(int i = 1; i < A.length; i++){
            int num = A[i];
            int tempMax = max * num;
            int tempMin = min * num;
            max = Math.max(tempMax, Math.max(num, tempMin));
            min = Math.min(tempMax, Math.min(num, tempMin));
            answer = Math.max(answer, max);
        }
        return answer; 
    }
    
    public static void main(String[] args) {
        int num = maxProduct(new int[]{-4, -3 ,-2});
        System.out.println(num);
    }
}
