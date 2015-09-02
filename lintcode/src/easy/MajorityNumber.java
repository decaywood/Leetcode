package easy;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/9/1 9:33
 *
 * Given an array of integers, the majority number is the
 * number that occurs more than half of the size of the array. Find it.
 *
 * Example
 * Given [1, 1, 1, 1, 2, 2, 2], return 1
 *
 * Challenge
 * O(n) time and O(1) extra space
 *
 * ˼·��ͬʱɾ������Ԫ�أ������һ��Ԫ�س���������ض�Ϊcandidate
 *
 * ���磺[1, 1, 1, 1, 2, 3, 4] ͨ�����㣬1��count����Ϊ1����Ϊcandidate
 *
 */
public class MajorityNumber {

    public static int majorityNumber(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0) return -1;
        int candidate = nums.get(0);
        int count = 1;
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            if(count == 0) candidate = num;
            if(candidate == num) count++;
            else count--;
        }
        return candidate;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        int[] arr = new int[]{2,2,2,2,1,1,1,1,1};
        for (int i : arr) nums.add(i);
        System.out.println(majorityNumber(nums));
    }

}
