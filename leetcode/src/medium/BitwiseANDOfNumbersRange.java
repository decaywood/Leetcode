package medium;

/**
 * @author: decaywood
 * @date: 2015/10/1 17:25
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 *
 * �����ȴ���Ŀ�и���������������[5, 7]�ﹲ���������֣��ֱ�д�����ǵĶ�����Ϊ��
 * 101����110����111
 * �����Ľ��Ϊ100����ϸ�۲����ǿ��Եó����������Ǹ����ַ�Χ�����е�������߹�ͬ�Ĳ��֣�
 * ��������Ǹ����Ӳ�̫���ԣ�����������һ����Χ[26, 30]�����ǵĶ��������£�
 * 11010����11011����11100����11101����11110
 * �����˹��ɺ�����ֻҪд�����ҵ���߹����Ĳ��ּ���
 *
 */
public class BitwiseANDOfNumbersRange {

   /* public int rangeBitwiseAnd(int m, int n) {
        int res = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            res &= i;
        }
        return res;
    }*/

    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++i;
        }
        return (m << i);
    }


}
