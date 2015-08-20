package medium;

import java.util.stream.IntStream;

/**
 * @author: decaywood
 * @date: 2015/8/19 21:33
 *
 *
 * Given an array of numbers nums,in which exactly two elements appear only once
 * and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 *
 * For example:
 *
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only
 * constant space complexity?
 *
 * ����֪����������ȵ��������Ϊ0����ˣ��״�ɨ�����飬�õ�������������A��B�������AxorB��
 * ��ΪA��B����ȣ����AxorBһ����Ϊ0���Ҷ�����λΪ1��λA��Bһ����ͬ����ȡAxorB�е�һ��������λ��
 * ���Խ�ԭ����Ԫ�طֳ�������򼴵ý����ע��n&(~(n-1))��ʾȡ��n�е����һλ������λ��
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int X_OR = IntStream.of(nums).reduce(0, (x, y) -> x ^ y);
        X_OR &= -X_OR;
        final int[] ans = {0, 0};
        for (int num : nums) {
            if((X_OR & num) == 0) ans[0] ^= num;
            else ans[1] ^= num;
        }
        return ans;
    }


}
