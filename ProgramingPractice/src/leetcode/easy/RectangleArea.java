package leetcode.easy;

/**
 * @author: decaywood
 * @date: 2015/8/11 16:57
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C-A)*(D-B) + (G-E)*(H-F);
        if (A >= G || B >= H || C <= E || D <= F) return area;
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        return area - (top-bottom)*(right-left);
    }

}

