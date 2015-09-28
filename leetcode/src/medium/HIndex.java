package medium;

import java.util.Arrays;

/**
 * @author: decaywood
 * @date: 2015/9/27 7:31
 *
 * Given an array of citations (each citation is a non-negative integer)
 * of a researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N ? h papers have no more than h citations each."
 *
 * For example, given citations = [3, 0, 6, 1, 5],
 * which means the researcher has 5 papers in total and each of them had
 * received 3, 0, 6, 1, 5 citations respectively. Since the researcher
 * has 3 papers with at least 3 citations each and the remaining two with
 * no more than 3 citations each, his h-index is 3.
 *
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 */
public class HIndex {

    public int hIndex(int[] citations) {
        int res = 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0 ; i--) {
            int num = citations.length - i;
            if(citations[i] >= num) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{3, 0, 6, 1, 5}));

    }
}
