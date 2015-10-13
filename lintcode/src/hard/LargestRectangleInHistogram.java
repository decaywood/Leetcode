package hard;

import java.util.Arrays;
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
 *
 */
public class LargestRectangleInHistogram {

  /*  public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int[] histogram = new int[height.length + 1];
        System.arraycopy(height, 0, histogram, 0, height.length);
        Deque<Integer> deque = new LinkedList<>();
        int largestArea = 0;
        for (int i = 0; i < histogram.length;) {
            if (deque.isEmpty() || histogram[deque.peek()] <= histogram[i]) deque.push(i++);
            else {
                int index = deque.pop();
                largestArea = Math.max(largestArea, (deque.isEmpty() ? i : i - index) * histogram[index]);
            }

        }
        return largestArea;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{5,5,1,7,1,1,5,2,7,6}));
    }*/

}
