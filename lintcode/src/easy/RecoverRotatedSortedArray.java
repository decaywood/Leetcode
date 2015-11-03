package easy;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/11/3 15:05
 *
 * Given a rotated sorted array, recover it to sorted array in-place.
 *
 * Example
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 *
 * Challenge
 * In-place, O(1) extra space and O(n) time.
 *
 * Clarification
 * What is rotated array?
 *
 * For example, the orginal array is [1,2,3,4],
 * The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 *
 */
public class RecoverRotatedSortedArray {

    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if(nums.isEmpty()) return;
        int begin = getNode(nums);
        if(begin == -1) return;
        reverse(nums, 0, begin - 1);
        reverse(nums, begin, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }

    private int getNode(ArrayList<Integer> arrayList) {
        int pre = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i) < pre) return i;
            pre = arrayList.get(i);
        }
        return -1;
    }

    private void reverse(ArrayList<Integer> arr, int begin, int end) {
        for (; begin < end; begin++, end--) {
            int temp = arr.get(begin);
            arr.set(begin, arr.get(end));
            arr.set(end, temp);
        }
    }

}
