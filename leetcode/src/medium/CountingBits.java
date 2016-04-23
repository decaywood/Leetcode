package medium;

/**
 * @author: decaywood
 * @date: 2016/04/23 20:59
 * <p>
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin
 * function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits {

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = count(i);
        }
        return res;
    }

    private static int count(int num) {
        int count = 0;
        for (;num > 0;) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        for (int i : countBits(5)) {
            System.out.println(i);

        }
    }

}
