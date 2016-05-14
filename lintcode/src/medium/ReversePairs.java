package medium;

/**
 * @author: decaywood
 * @date: 2016/4/24 12:39.
 * <p>
 * For an array A, if i < j, and A [i] > A [j], called (A [i], A [j]) is a reverse pair.
 * return total of reverse pairs in A.
 *
 * Given A = [2, 4, 1, 3, 5] , (2, 1), (4, 1), (4, 3) are reverse pairs. return 3
 *
 */
public class ReversePairs {

    public static long reversePairs(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int v1 = A[i];
            for (int j = i + 1; j < A.length; j++) {
                int v2 = A[j];
                if (v1 > v2) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{4,3,2,1}));
    }

}
