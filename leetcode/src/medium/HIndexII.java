package medium;

/**
 * @author: decaywood
 * @date: 2015/9/27 8:09
 *
 * Follow up for H-Index:
 * @see HIndex
 * What if the citations array is sorted in ascending order?
 * Could you optimize your algorithm?
 *
 * 思路：二分查找
 *
 */
public class HIndexII {

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        return hIndex(citations, 0, citations.length - 1);
    }


    public int hIndex(int[] citations, int i, int j) {
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            int num = citations.length - mid;
            int temp = citations[i];
            i = temp >= num ? i : mid;
            j = temp >= num ? mid : j;
        }
        while (i >= 0 && citations[i] >= citations.length - i) i--;
        return citations[citations.length - 1] < 1 ? 0 : citations.length - i - 1;
    }

    public static void main(String[] args) {
        System.out.println(new HIndexII().hIndex(new int[]{1}));
        System.out.println(new HIndexII().hIndex(new int[]{1,2,3,4,5,6}));
        System.out.println(new HIndexII().hIndex(new int[]{1,1,1,1,3,3,4,4,5,6,7,7,8,9,10}));
    }
}
