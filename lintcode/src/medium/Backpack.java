package medium;

/**
 * @author: decaywood
 * @date: 2015/9/15 12:40
 *
 * Given n items with size Ai, an integer m denotes the size of a backpack.
 * How full you can fill this backpack?
 *
 * Example
 * If we have 4 items with size [2, 3, 5, 7], the backpack size is 11,
 * we can select [2, 3, 5], so that the max size we can fill this backpack is 10.
 * If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
 *
 * You function should return the max size we can fill in the given backpack.
 *
 * Note
 * You can not divide any item into small pieces.
 *
 * Challenge
 * O(n x m) time and O(m) memory.
 *
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 *
 */
public class Backpack {


   /* public int backPack(int m, int[] A) {
        int[] dp = new int[m + 1];
        int[] temp = new int[m + 1];
        for (int weight : A) {
            for (int index = 1; index < dp.length; index++) {
                if ((index - weight) < 0) continue;
                dp[index] = Math.max(temp[index - weight] + weight, temp[index]);
            }
            System.arraycopy(dp, 0, temp, 0, dp.length);
        }
        return dp[m];
    }*/

    /**
     * 更好的解法
     */
    public int backPack(int m, int[] A) {
        int[] result=new int[m+1];
        for (int weight : A) {
            for (int j = m; j >= weight; j--)
                result[j] = Math.max(result[j - weight] + weight, result[j]);
        }
        return result[m];
    }

    public static void main(String[] args) {
        new Backpack().backPack(90, new int[]{12,3,7,4,5,13,2,8,4,7,6,5,7});
    }

}
