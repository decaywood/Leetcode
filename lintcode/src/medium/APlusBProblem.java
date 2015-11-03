package medium;

/**
 * @author: decaywood
 * @date: 2015/11/3 9:47
 *
 * Write a function that add two numbers A and B. You should not use + or any arithmetic operators.
 *
 * Example
 * Given a=1 and b=2 return 3
 *
 * Note
 * There is no need to read data from standard input stream.
 * Both parameters are given in function aplusb, you job is to calculate the sum and return it.
 *
 * Challenge
 * Of course you can just return a + b to get accepted.
 *
 * But Can you challenge not do it like that?
 * Clarification
 * Are a and b both 32-bit integers?
 * Yes.
 * Can I use bit operation?
 * Sure you can.
 *
 * 定理1：设a，b为两个二进制数，则a+b = a^b + (a&b)<<1。
 * 证明：a^b是不考虑进位时加法结果。当二进制位同时为1时，
 * 才有进位，因此 (a&b)<<1是进位产生的值，称为进位补偿。
 * 将两者相加便是完整加法结果。
 * 定理2：使用定理1可以实现只用位运算进行加法运算。
 * 证明：利用定理1中的等式不停对自身进行迭代。
 * 每迭代一次，进位补偿右边就多一位0，
 * 因此最多需要加数二进制位长度次迭代，进位补偿就变为0，这时运算结束。
 *
 */
public class APlusBProblem {

    int aplusb(int a, int b) {
        if(b == 0) return a;
        return aplusb(a ^ b, (a & b) << 1);
    }

}
