package hard;

import java.math.BigDecimal;

/**
 * @author: decaywood
 * @date: 2015/8/31 20:53.
 *
 * Given a (decimal - e.g. 3.72) number that is passed in as a string,
 * return the binary representation that is passed in as a string.
 * If the fractional part of the number can not be represented accurately
 * in binary with at most 32 characters, return ERROR.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * For n = "3.72", return "ERROR".
 *
 * For n = "3.5", return "11.1".
 *
 */
public class BinaryRepresentation {

    public static String binaryRepresentation(String n) {
        String[] strs = n.split("\\.");
        int integer = Integer.parseInt(strs[0]);
        BigDecimal decimal = new BigDecimal(n).subtract(new BigDecimal(integer));
        StringBuilder strInteger = new StringBuilder();
        StringBuilder strDecimal = new StringBuilder();
        while (integer > 0) {
            strInteger.append(integer % 2);
            integer /= 2;
        }
        strInteger = strInteger.length() == 0 ? strInteger.append("0") : strInteger.reverse();
        int time = 32;
        BigDecimal zero = new BigDecimal("0");
        BigDecimal one = new BigDecimal("1");
        BigDecimal two = new BigDecimal("2");
        if(decimal.compareTo(zero) != 0) strInteger.append(".");
        while (time-- > 0 && decimal.compareTo(zero) != 0) {
            decimal = decimal.multiply(two);
            strDecimal.append(decimal.intValue());
            decimal = decimal.intValue() >= 1 ? decimal.subtract(one) : decimal;
        }
        return decimal.compareTo(zero) == 0 ? strInteger.append(strDecimal.toString()).toString() : "ERROR";
    }

    public static void main(String[] args) {
        System.out.println(binaryRepresentation("0.5"));
    }

}
