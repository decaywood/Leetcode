package medium;

import java.util.Arrays;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/1 21:51.
 */
public class SingleNumberIII {

    public static List<Integer> singleNumberIII(int[] A) {
        int xor = 0;
        for (int i : A) xor ^= i;
        xor &= -xor;
        int a = 0;
        int b = 0;
        for (int i : A)
            if ((i & xor) == 0) a ^= i;
            else b ^= i;
        return Arrays.asList(a, b);
    }

    public static void main(String[] args) {
        singleNumberIII(new int[]{1,2,3,3,2,4,1,5});
    }

}
