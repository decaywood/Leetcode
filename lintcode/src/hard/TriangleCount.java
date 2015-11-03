package hard;

/**
 * @author: decaywood
 * @date: 2015/10/24 11:54.
 *
 * Given an array of integers, how many three numbers can be found in the array,
 * so that we can build an triangle whose three edges length is the three numbers that we find?
 *
 * Example
 * Given array S = [3,4,6,7], return 3. They are:
 *
 * [3,4,6]
 * [3,6,7]
 * [4,6,7]
 *
 * Given array S = [4,4,4,4], return 4. They are:
 *
 * [4(1),4(2),4(3)]
 * [4(1),4(2),4(4)]
 * [4(1),4(3),4(4)]
 * [4(2),4(3),4(4)]
 *
 */
public class TriangleCount {

    public int triangleCount(int S[]) {
        if(S.length < 3) return 0;
        int[] count = new int[1];
        triangleCount(S, count, 0, 0, 0, 0);
        return count[0];
    }

    public void triangleCount(int[] S, int[] count, int start, int sum, int max, int level) {
        if (level == 3) {
            if(isTriangle(sum, max)) count[0]++;
            return;
        }
        for (int i = start; i < S.length; i++) {
            int num = S[i];
            triangleCount(S, count, i + 1, sum + num, Math.max(max, num), level + 1);
        }
    }

    private boolean isTriangle(int sum, int max) { return sum - max > max; }


}
