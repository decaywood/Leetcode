package medium;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/9/1 22:27.
 *
 * Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.
 *
 * Find it.
 *
 * Example
 * Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.
 *
 * Note
 * There is only one majority number in the array.
 *
 * Challenge
 * O(n) time and O(k) extra space
 *
 * ˼·��ʹ��HashMap����k��ֵ��keyΪ�����е�Ԫ��ֵ��valueΪ��ֵ���ֵĴ�����
 * ��ͬʱ��k����ͬ��Ԫ����map�У������һ�Σ�������value��һ����ɾ��valueΪ���key��
 * ����һ���map��value����keyΪ�𰸡�
 *
 */
public class MajorityNumberIII {

    public static int majorityNumber(List<Integer> nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (Integer num : nums) {
            if(!hashMap.containsKey(num)) hashMap.put(num, 0);
            hashMap.put(num, hashMap.get(num) + 1);
        }
        int maxTime = Integer.MIN_VALUE;
        int val = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxTime) {
                maxTime = entry.getValue();
                val = entry.getKey();
            }
        }
        return val;
    }

    public static void main(String[] args) {
        majorityNumber(Arrays.asList(2, 2, 5, 1), 3);
    }

}
