package medium;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/8/27 21:55.
 *
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 *
 * Challenge
 * O(log n) time.
 *
 */
public class SearchForARange {

    public static ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int start = A.size() == 1 ? A.get(0) == target ? 0 : -1 : -1;
        int end = A.size() == 1 ? A.get(0) == target ? 0 : -1 : -1;
        if(A.size() >= 2){
            start = findStart(A, 0, A.size() - 1, target);
            end = findEnd(A, 0, A.size() - 1, target);
            start = A.get(start) == target ? start : -1;
            end = A.get(end) == target ? end : -1;
        }
        arrayList.add(start);
        arrayList.add(end);
        return arrayList;
    }


    private static int findStart(ArrayList<Integer> list, int left, int right, int target) {
        int mid = (left + right) / 2;
        if(left + 1 == right || left == right) return list.get(left) != target ? right : left;
        if (list.get(mid) == target) {
            return findStart(list, left, mid, target);
        } else return list.get(mid) > target ? findStart(list, left, mid - 1, target) : findStart(list, mid, right, target);
    }

    private static int findEnd(ArrayList<Integer> list, int left, int right, int target) {
        int mid = (left + right) / 2;
        if(left + 1 == right || left == right) return list.get(right) != target ? left : right;
        if (list.get(mid) == target) {
            return findEnd(list, mid, right, target);
        } else return list.get(mid) < target ? findEnd(list, mid + 1, right, target) : findEnd(list, left, mid, target);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] arr = new int[]{1,3,5,6,8,9};
        for (int i : arr) arrayList.add(i);
        searchRange(arrayList, 7);
    }
}
