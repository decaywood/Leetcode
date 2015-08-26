package easy;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/8/26 13:07
 *
 * Merge two given sorted integer array A and B into a new sorted integer array.
 *
 * Example
 * A=[1,2,3,4]
 *
 * B=[2,4,5,6]
 *
 * return [1,2,2,3,4,4,5,6]
 *
 * Challenge
 * How can you optimize your algorithm if one array is very large and the other is very small?
 *
 */
public class MergeSortedArrayII {

    public static ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (arrayList.size() < A.size() + B.size()) {
            int val;
            if (j == B.size() || (i < A.size() && A.get(i) <= B.get(j))) val = A.get(i++);
            else val = B.get(j++);
            arrayList.add(val);
        }
        return arrayList;
    }




}
