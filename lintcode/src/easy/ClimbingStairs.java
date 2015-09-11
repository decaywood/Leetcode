package easy;

/**
 * @author: decaywood
 * @date: 2015/9/11 13:05
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 *
 * return 3
 *
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i + 1 < arr.length; i++) {
            arr[i] += arr[i - 1];
            arr[i + 1] += arr[i - 1];
        }
        return arr[arr.length - 1] + arr[arr.length - 2];
    }
}
