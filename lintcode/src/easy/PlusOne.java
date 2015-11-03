package easy;

/**
 * @author: decaywood
 * @date: 2015/10/22 23:15.
 *
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example
 * Given [1,2,3] which represents 123, return [1,2,4].
 *
 * Given [9,9,9] which represents 999, return [1,0,0,0].
 *
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            carry = (num) / 10;
            digits[i] = num % 10;
        }
        if(carry != 0) {
            int[] temp = new int[digits.length + 1];
            System.arraycopy(digits, 0, temp, 1, digits.length);
            temp[0] = carry;
            digits = temp;
        }
        return digits;
    }

    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{9});
    }
}
