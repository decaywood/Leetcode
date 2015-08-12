package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    /*
     *   Given an array of integers, every element appears twice except for one. Find that single one.
     *   Note:
     *   Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */
    
    public int singleNumber1(int[] A) {  // 解法一： 利用相同的数亦或为0的性质
        if(A == null)
            return 0;
        int result = 0;
        for(int num : A){
            result ^= num;
        }
        return result;
    }
    
    public int singleNumber2(int[] A) {  // 解法二： hashset
        if(A == null)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        for(int num : A){
           if(map.containsKey(num)){
               map.remove(num);
           }
           else {
               map.put(num, num);
           }
        }
        int a = 0;
        for(int num : A){
            if(map.containsKey(num))
                a = map.get(num);
        }
        return a;
    }
}
