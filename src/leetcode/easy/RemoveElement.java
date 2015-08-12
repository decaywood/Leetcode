package leetcode.easy;

public class RemoveElement {

    /**
     * Given an array and a value, remove all instances of that value in place
     * and return the new length.
     * 
     * The order of elements can be changed. It doesn't matter what you leave
     * beyond the new length.
     */

    /**
     * 我一开始以为自己求删除之后的长度就可以了！其实不止如此！你还要让A数组前length符合要求。
     */

    public int removeElement(int[] A, int elem) {
        int offset = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem)
                A[offset++] = A[i];
        }
        return offset;
    }
}
