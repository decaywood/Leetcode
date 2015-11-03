package medium;

/**
 * @author: decaywood
 * @date: 2015/10/26 22:28.
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Example
 * Given [1,3,2], the max area of the container is 2.
 *
 * Note
 * You may not slant the container.
 *
 */
public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                max = Math.max(max, (j - i) * Math.min(heights[i], heights[j]));
            }
        }
        return max;
    }

}
