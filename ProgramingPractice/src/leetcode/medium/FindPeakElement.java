package leetcode.medium;

/**
 * @author decaywood
 * 
 * 2015年1月4日
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * 
 * 
 * 思路：类似动态规划，假设元素i-1一定比元素i小（否则返回结果），则只要判断元素i是否大于i+1即可
 * 注意左右边界：若数组只有一个元素返回0。若i已经到达倒数第二的元素，且还没达到返回要求则直接返回最后一个元素
 * 
 */
public class FindPeakElement {
    
    public int findPeakElement(int[] num) {
        int peakIndex = 0;
        
        if(num.length < 2)
            return 0;
        
        for(int i = 0; i < num.length - 1; i++){
            if(num[i] > num[i+1])
                return i;
            if(i == num.length - 2)
                return num.length - 1;
        }
        
        return peakIndex;
    }

}
