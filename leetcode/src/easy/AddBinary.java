package easy;

/**
 * @author: decaywood
 * @date: 2015/9/28 17:07
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        String longStr = a.length() > b.length() ? a : b;
        String shortStr = longStr.equals(b) ? a : b;
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = longStr.length() - 1, j = shortStr.length() - 1; i >= 0; i--, j--) {
            int bit = (longStr.charAt(i) - '0') ^ (j >= 0 ? shortStr.charAt(j) - '0' : 0);
            builder.append(bit ^ carry);
            carry = carry + (longStr.charAt(i) - '0') + (j >= 0 ? shortStr.charAt(j) - '0' : 0) >= 2 ? 1 : 0;
        }
        if(carry == 1) builder.append(carry);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1", "0"));
    }

}
