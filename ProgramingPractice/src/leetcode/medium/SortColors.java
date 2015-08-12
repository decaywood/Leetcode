package leetcode.medium;

/**
 * @author decaywood
 * 
 * 2015年1月23日
 * 
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * 思路：这题简单得过头了吧。。。。
 */
public class SortColors {
    
    public static void sortColors(int[] A) {
        
        //插入排序
        for(int i = 1; i < A.length; i++){
            int j = i;
            int key = A[i];
            while(j > 0 && A[j - 1] > key){
                A[j] = A[j - 1]; 
                j--;
            }
            A[j] = key;
        }
    }
    
    
    public static void main(String[] args) {
        sortColors(new int[]{9,7,1,1,2,4,2});
    }

}
