package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ThreeSum {
     /*
     *   Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     *
     *   Note:
     *   Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     *   The solution set must not contain duplicate triplets.
     *       For example, given array S = {-1 0 1 2 -1 -4},
     *
     *   A solution set is:
     *   (-1, 0, 1)
     *   (-1, -1, 2)
     * 
     * 
     */
    public List<List<Integer>> threeSum(int[] num) {
        if(num.length < 3)
            return new LinkedList<List<Integer>>();
        int target = 0;
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Set<Integer> firstSet = new HashSet<Integer>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            int key = num[i];
            if(key > 0)  //第一个数必定是小于1的数
                break;
            if(firstSet.contains(key))
                continue;
            List<int[]> indexsList = twoSum(num, target - key, i + 1);
            List<Integer> childList= new ArrayList<Integer>();
            Set<Integer> secondSet = new HashSet<Integer>();
            for(int[] indexs : indexsList){
                if(secondSet.contains(indexs[0])) //去除返回的twoSum重复值
                    continue;
                childList.add(key);
                childList.add(indexs[0]);
                childList.add(indexs[1]);
                secondSet.add(indexs[0]);
                list.add(childList);
                childList = new ArrayList<Integer>();
            }
            firstSet.add(key); //第一个数必定不会重复，因为 twoSum()已经找出对应所有可能解
        }
        return list;
    }
   
    public List<int[]> twoSum(int[] numbers, int target, int start){
        int[] indexs = null;
        List<int[]> list = new ArrayList<int[]>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = start; i < numbers.length; i++) {
            int num = numbers[i];
            if (map.containsKey(num)) {
                indexs = new int[2];
                indexs[0] = Math.min(num, map.get(num));
                indexs[1] = Math.max(num, map.get(num));
                list.add(indexs);
                map.remove(indexs[0]);  //清空符合要求的数据，减少重复的数据造成不必要的计算的次数
                map.remove(indexs[1]);
            }
            map.put(target - num, num);   //这一步非常关键： key -> 期待的第三个数， value -> 第二个数
        }
        return list;
    }
    
    public static void main(String[] args) {
//        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4,2});
        new ThreeSum().threeSum(new int[]{0, 0, 0, 0});
    }
}
