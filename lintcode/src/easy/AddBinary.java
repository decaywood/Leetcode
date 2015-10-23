package easy;

/**
 * @author: decaywood
 * @date: 2015/10/23 20:29.
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * Example
 * a = 11
 * b = 1
 *
 * Return 100
 *
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= Math.max(a.length(), b.length()); i++) {
            int numA = i <= a.length() ? a.charAt(a.length() - i) - '0' : 0;
            int numB = i <= b.length() ? b.charAt(b.length() - i) - '0' : 0;
            carry += numA + numB;
            builder.append(carry % 2);
            carry /= 2;
        }
        if(carry != 0) builder.append(carry);
        return builder.reverse().toString();
    }

}
