package easy;

/**
 * @author: decaywood
 * @date: 2015/11/3 15:25
 *
 * Implement function atoi to convert a string to an integer.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * If the correct value is out of the range of representable values,
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * Example
 * "10" => 10
 *
 * "-1" => -1
 *
 * "123123123123123" => 2147483647
 *
 * "1.0" => 1
 *
 */
public class StringToInteger {


    int atoi(String str) {
        int n = str.length();
        long val = 0;
        int f = 1;
        boolean sign = false;
        boolean digit = false;
        int i = 0;
        i = 0;
        while (i < n) {
            if (str.charAt(i)== '-') {
                if (digit || sign) {
                    break;
                }
                sign = true;
                f = -1;
            } else if (str.charAt(i) == '+') {
                if (digit || sign) {
                    break;
                }
                sign = true;
                f = 1;
            } else if (Character.isDigit(str.charAt(i))) {
                digit = true;
                val = val * 10 + (str.charAt(i) - '0');
                if (f * val < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (f * val > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else if (str.charAt(i) != ' ') {
                break;
            }
            ++i;
        }
        return (int) (f * val);
    }



    public static void main(String[] args) {
        System.out.println(new StringToInteger().atoi(" 15+4"));
    }
}
