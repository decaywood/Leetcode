package medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: decaywood
 * @date: 2015/11/3 13:59
 *
 * Find K-th largest element in an array.
 *
 * Example
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 *
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 *
 * Note
 * You can swap elements in the array
 *
 * Challenge
 * O(n) time, O(1) extra memory.
 *
 */
public class KthLargestElement {

    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        return kthLargestElement(numbers.size() - k + 1, numbers, 0, numbers.size() - 1);
    }

    public int kthLargestElement(int k, ArrayList<Integer> numbers, int start, int end) {
        int pivot = pivot(numbers, start, end);
        return k == pivot + 1 ? numbers.get(pivot) : k < pivot + 1 ? kthLargestElement(k, numbers, start, pivot - 1)
                : kthLargestElement(k, numbers, pivot + 1, end);
    }

    private int pivot(ArrayList<Integer> numbers, int start, int end) {
        int key = numbers.get(start);
        while (start < end) {
            while (start < end && numbers.get(end) >= key) end--;
            numbers.set(start, numbers.get(end));
            while (start < end && numbers.get(start) < key) start++;
            numbers.set(end, numbers.get(start));
        }
        numbers.set(start, key);
        return start;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 9, 3, 2, 4, 8);
        for (int i = 1; i < 5; i++) {
            System.out.println(new KthLargestElement().kthLargestElement(i, arrayList));
        }
    }


}
