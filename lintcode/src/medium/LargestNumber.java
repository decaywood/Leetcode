package medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: decaywood
 * @date: 2015/9/1 10:46
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example
 * Given [1, 20, 23, 4, 8], the largest formed number is 8423201.
 *
 * Note
 * The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class LargestNumber {

    public static String largestNumber(int[] num) {
        int max = IntStream.of(num).reduce(Integer.MIN_VALUE, Math::max);
        List<String> list = IntStream.of(num).mapToObj(String::valueOf).collect(Collectors.toList());
        if(max == 0) return "0";
        list.sort(LargestNumber::compare);
        StringBuilder builder = new StringBuilder();
        list.forEach(builder::append);
        return builder.toString();
    }

    private static int compare(String o1, String o2) {
        int maxLen = Math.max(o1.length(), o2.length());
        for (int i = 0; i < maxLen; i++) {
            char char1 = i >= o1.length() ? o1.charAt(o1.length() - 1) : o1.charAt(i);
            char char2 = i >= o2.length() ? o2.charAt(o2.length() - 1) : o2.charAt(i);
            if (char1 > char2) return -1;
            else if (char1 < char2) return 1;
        }
        return o1.length() < o2.length() ? 1 : o1.length() == o2.length() ? 0 : -1;
    }

    public static void main(String[] args) {
        largestNumber(new int[]{41,23,87,55,50,53,18,9,39,63,35,33,54,25,26,49,74,61,32,81,97,99,38,96,22,95,35,57,80,80,16,22,17,13,89,11,75,98,57,81,69,8,10,85,13,49,66,94,80,25,13,85,55,12,87,50,28,96,80,43,10,24,88,52,16,92,61,28,26,78,28,28,16,1,56,31,47,85,27,30,85,2,30,51,84,50,3,14,97,9,91,90,63,90,92,89,76,76,67,55});
    }

}
