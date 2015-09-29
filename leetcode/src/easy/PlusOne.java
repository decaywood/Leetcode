package easy;

/**
 * @author: decaywood
 * @date: 2015/9/28 11:04
 *
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 */
public class PlusOne {

   /* public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int res = digits[i] + carry;
            digits[i] = res % 10;
            carry = res / 10;
        }
        if (carry == 1) {
            int[] temp = new int[digits.length + 1];
            System.arraycopy(digits, 0, temp, 1, digits.length - 1);
            temp[0] = 1;
            digits = temp;
        }
        return digits;
    }*/

    /**
     * 更优化的方案
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }


}
