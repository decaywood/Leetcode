package easy;

import java.util.Arrays;

/**
 * @author decaywood
 * 
 * 2015年1月4日
 * 
 * Given an array of size n, find the majority element. The majority element is the element that 
 * appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * 思路：对数组进行排序，排序过后，数组的主元素必定位于数组中间的位置。
 * 
 */
public class MajorityElement {
    
    public int majorityElement(int[] num) {
        
        Arrays.sort(num);
        return num[num.length >> 1];
        
    }

    
    private int getMiddle(int[] num, int start, int end){
        
        int temp = num[start];
        
        while(start < end){
            while(start < end && num[end] >= temp) end--;
            num[start] = num[end];
            
            while(start < end && num[start] <= temp) start++;
            num[end] = num[start];
        }
        num[start] = temp;
        return start;
        
    }
    
     

}
