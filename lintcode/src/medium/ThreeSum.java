package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: decaywood
 * @date: 2015/8/25 15:46
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Example
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 *
 * (-1, 0, 1)
 * (-1, -1, 2)
 * Note
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 *
 * The solution set must not contain duplicate triplets.
 *
 * 思路：先选一个，剩下的左右扫描
 *
 */
public class ThreeSum {

    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if(numbers == null || numbers.length < 3) return arrayList;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                if(sum > 0) k--;
                else if(sum < 0) j++;
                else {
                    int hash = (numbers[i] * 31 + numbers[j]) * 31 + numbers[k];
                    if(set.contains(hash)) {
                        j++;
                        k--;
                        continue;
                    }
                    set.add(hash);
                    if(sum == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        arrayList.add(list);
                    }
                }
            }
        }
        return arrayList;
    }



}
