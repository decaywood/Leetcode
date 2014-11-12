package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum {

    /**
     * Given an array S of n integers, are there elements a, b, c, and d in S
     * such that a + b + c + d = target? Find all unique quadruplets in the
     * array which gives the sum of target.
     * 
     * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
     * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate
     * quadruplets. For example, given array S = {1 0 -1 0 -2 2}, and target =
     * 0.
     * 
     * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
     */
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> childList = new ArrayList<Integer>();
        Set<Integer> firstSet = new HashSet<Integer>();
        Arrays.sort(num);
        if(num.length < 4)
            return new ArrayList<List<Integer>>();
        for(int firstIndex = 0; firstIndex < num.length - 3; firstIndex++){
            
            int first = num[firstIndex];
            
            if(firstSet.contains(first)) // 确定第一个数后，会保证找出所有的另外三个数的组合，固第一个数必不会重复
                continue;
            
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            
            for(int fourthIndex = num.length - 1; fourthIndex > firstIndex + 2; fourthIndex-- ){
                
                int fourth = num[fourthIndex];
                int remain = target - first - fourth;
                int secondIndex = firstIndex + 1;
                int thirdIndex = fourthIndex - 1;
                
                while (secondIndex < thirdIndex) {
                    int second = num[secondIndex];
                    int third = num[thirdIndex];
                    if(second + third < remain){
                        secondIndex++;
                    }
                    else if(second + third > remain){
                        thirdIndex--;
                    }
                    else{
                        secondIndex++;
                        thirdIndex--;
                        if(map.containsKey(second) && map.get(second) == third)  //判断是否重复
                            continue;
                        childList.add(first);
                        childList.add(second);
                        childList.add(third);
                        childList.add(fourth);
                        list.add(childList);
                        childList = new ArrayList<Integer>();
                        map.put(second, third);
                    } 
                }
            }
            
            firstSet.add(first);
            
        }
        return list;
    }
    
 
    
    
    public static void main(String[] args) {
        new FourSum().fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
    }
}
