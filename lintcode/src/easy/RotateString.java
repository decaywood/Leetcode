package easy;

/**
 * @author: decaywood
 * @date: 2015/11/3 10:46
 *
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 *
 * Example
 * Given "abcdefg".
 *
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * Challenge
 * Rotate in-place with O(1) extra memory.
 *
 */
public class RotateString {

    /**
     * step1 : reverse left half part str
     * step2 : reverse right half part str
     * step3 : reverse whole part str
     *
     * for example: abcdefg -> efgabcd:
     * 1 dcbaefg
     * 2 dcbagfe
     * 3 efgabcd
     *
     */
    public void rotateString(char[] str, int offset) {
        if(str.length == 0) return;
        offset %= str.length;
        int begin = str.length - offset;
        reverse(str, 0, begin - 1);
        reverse(str, begin, str.length - 1);
        reverse(str, 0, str.length - 1);
    }


    private void reverse(char[] str, int begin, int end) {
        for (; begin < end; begin++, end--) {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
        }
    }


}
