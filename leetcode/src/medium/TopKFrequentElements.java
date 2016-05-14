package medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: decaywood
 * @date: 2016/05/14 08:42
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 */
public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.putIfAbsent(num, 0);
            counter.computeIfPresent(num, (key, oldVal) -> oldVal + 1);
        }
        Map.Entry[] counted = new Map.Entry[counter.size()];
        int index = 0;
        for (Map.Entry entry : counter.entrySet()) {
            counted[index++] = entry;
        }
        return reduce(counted, k);
    }

    public static List<Integer> reduce(Map.Entry<Integer, Integer>[] array, int k) {
        List<Integer> res = new ArrayList<>(k);
        partialSort(array, Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed(), k, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            res.add(array[i].getKey());
        }
        return res;
    }
    public static void partialSort(Map.Entry[] arr, Comparator<Map.Entry<Integer, Integer>> comparator, int k, int left, int right) {
        if (left < right) {
            int pivot = pivot(arr, comparator, left, right);
            if (pivot > k) return;
            partialSort(arr, comparator, k, left, pivot - 1);
            partialSort(arr, comparator, k, pivot + 1, right);
        }
    }

    private static int pivot(Map.Entry<Integer, Integer> arr[], Comparator<Map.Entry<Integer, Integer>> comparator, int start, int end) {
        Map.Entry<Integer, Integer> key = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && comparator.compare(arr[right], key) >= 0) right--;
            arr[left] = arr[right];
            while (left < right && comparator.compare(arr[left], key) < 0) left++;
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }


    // java 8 solution
    public static List<Integer> _topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.putIfAbsent(num, 0);
            counter.computeIfPresent(num, (key, oldVal) -> oldVal + 1);
        }
        return counter.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
