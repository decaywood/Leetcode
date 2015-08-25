package easy;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/8/24 21:39.
 *
 * Given an integers array A.
 *
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.
 *
 * Example
 * For A = [1, 2, 3], return [6, 3, 2].
 *
 * 注意乘法溢出问题
 *
 */
public class ProductOfArrayExcludeItself {

    public static ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> res = new ArrayList<>();
        long[] temp = new long[A.size()];
        long resVal = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            resVal *= A.get(i);
            temp[i] = resVal;
        }
        resVal = 1;
        for (int i = 0; i < A.size(); i++) {
            temp[i] = resVal * A.get(i);
            res.add(resVal * (i + 1 == A.size() ? 1 : temp[i + 1]));
            resVal = temp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        productExcludeItself(arrayList);
    }
}
