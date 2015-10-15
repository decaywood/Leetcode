package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/10/11 19:57.
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * histogram
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * histogram
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        int i;
        for (i = 0; i < height.length; ) {
            if (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int index = stack.pop();
                int temp = stack.isEmpty() ? i * height[index] : ((i - 1) - (stack.peek() + 1) + 1) * height[index];
                res = Math.max(res, temp);
            } else stack.push(i++);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int temp = stack.isEmpty() ? i * height[index] : (i - stack.peek() - 1) * height[index];
            res = Math.max(res, temp);
        }
        return res;
    }

}
