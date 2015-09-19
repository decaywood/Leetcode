package medium;

/**
 * @author: decaywood
 * @date: 2015/9/11 15:38
 *
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * Example
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 *
 */
public class MaximumProductSubarray {



    public int maxProduct(int[] nums) {
        int productMax = nums[0];
        int productMin = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(productMax * nums[i], productMin * nums[i]));
            productMin = Math.min(nums[i], Math.min(productMax * nums[i], productMin * nums[i]));
            productMax = tempMax;
            ans = Math.max(ans, productMax);
        }
        return ans;
    }



}
