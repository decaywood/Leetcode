package leetcode.easy;

/**
 * Created by decaywood on 29/03/15.
 *
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 *
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 *
 */
public class NumberOf1Bits {

    /*
    *
    * 思路： 可以将number和自身减1相与，这样就相当于从number从左往右数第一个1消去（性质1）
    *
    * 性质1：给定一个数n，n-1的二进制表示相当于n从右数第一个1往右取反
    *
    * */
    public static int hammingWeight(int n) {

        int number = n;
        int count = 0;

        while (number > 0){
            number = number & (number - 1);
            count ++;
        }

        return count;

    }


    public static void main(String[] args) {

        System.out.println(hammingWeight(11));

    }

}
