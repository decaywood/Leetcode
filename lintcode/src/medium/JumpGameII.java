package medium;

/**
 * @author: decaywood
 * @date: 2015/9/1 20:42.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example
 * Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * 思路：找出当前点移动范围内的下一跳集合中最大移动范围的点，并递归迭代即可（因为移动范围最大的点必然包括更多选择，更大几率找到跳数最小的方案--贪心算法）。
 *
 */
public class JumpGameII {

    public static int jump(int[] A) {
        return jump(A, 0, 0);
    }
    public static int jump(int[] A, int start, int stepNum) {
        int step = A[start];
        int bounds = start + step;
        if(bounds >= A.length - 1) return stepNum + 1;
        int maxStep = Integer.MIN_VALUE;
        int index = start + 1;
        for (int i = start + 1; i <= bounds; i++)
            if (A[i] >= maxStep) {
                maxStep = A[i];
                index = i;
            }
        return jump(A, index, stepNum + 1);
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
