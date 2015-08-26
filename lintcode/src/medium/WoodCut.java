package medium;

/**
 * @author: decaywood
 * @date: 2015/8/26 22:54.
 *
 * Given n pieces of wood with length L[i] (integer array).
 * Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length.
 * What is the longest length you can get from the n pieces of wood? Given L & k,
 * return the maximum length of the small pieces.
 *
 * Example
 * For L=[232, 124, 456], k=7, return 114.
 *
 * Note
 * You couldn't cut wood into float length.
 *
 * Challenge
 * O(n log Len), where Len is the longest length of the wood.
 *
 */
public class WoodCut {

    public static int woodCut(int[] L, int k) {
        int maxLen = Integer.MIN_VALUE;
        for (int len : L) maxLen = Math.max(maxLen, len);
        long left = 0;
        long right = maxLen;
        long res = 0;
        while (left <= right) {
            long middle = (left + right) / 2;
            if(middle == 0) break;
            int pieces = calculatePieces(L, middle);
            if(right - left <= 2) {
                res = pieces == k ? middle : pieces < k ? left : right;
                break;
            }
            left = pieces < k ? left : middle + 1;
            right = pieces < k ? middle - 1 : right;
        }
        if(res == 0) return 0;
        while (calculatePieces(L, res) == k) res++;
        return (int) res - 1;
    }

    private static int calculatePieces(int[] L, long len) {
        int sum = 0;
        for (int length : L) sum += length / len;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(woodCut(new int[]{232,124,456}, 7));
        System.out.println(woodCut(new int[]{2147483644,2147483645,2147483646,2147483647}, 4));
    }

}
