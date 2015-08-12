package leetcode.medium;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author decaywood
 * 
 * 2015年1月22日
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer
 * 
 * 思路：
 * 分三步建立优先级规则即可
 * 1、前n位较大优先考虑
 * 2、长度一样 则任意皆可
 * 3、长度不一样，且前n位一样，直接比较交换顺序大小
 */
public class LargestNumber {
    
    public static String largestNumber(int[] num) {
        
        Set<String> set = new TreeSet<String>(new Comparator<String>() {

            @Override
            public int compare(String t1, String t2) {
                
                
                int lenMin = Math.min(t1.length(), t2.length());
                int lenMax = Math.max(t1.length(), t2.length());
                
                //step1 前n位较大优先考虑
                for(int i = 0; i < lenMin; i++){
                    if(t1.charAt(i) > t2.charAt(i))
                        return -1;
                    if(t1.charAt(i) < t2.charAt(i))
                        return 1;
                }
                
                //step2 长度一样 则任意皆可
                if(lenMax == lenMin) return 1;
                
                //step3  长度不一样，且前n位一样，直接比较交换顺序大小
                int i1 = Integer.valueOf(t1 + t2);
                int i2 = Integer.valueOf(t2 + t1);
                if(i1 > i2)
                    return -1;
                
                    
                return 1;
            }
        });
        
        for(int i : num)
            set.add(String.valueOf(i));
        
        StringBuilder builder = new StringBuilder();
        
        for(String here : set)
            builder.append(here);
        
        return builder.charAt(0) == '0' ? "0" : builder.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{1,1,1}));
    }

}
