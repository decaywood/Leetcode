package medium;

/**
 * @author: decaywood
 * @date: 2015/9/1 22:20.
 *
 * Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.
 *
 * Example
 * Given [1,1,2,3,3,3,2,2,4,1] return 4
 *
 * Challenge
 * One-pass, constant extra space.
 */
public class SingleNumberII {

    public int singleNumberII(int[] A) {
        int one = 0, two = 0, three;
        for (int i = 0; i < A.length; i++) {
            three = two & A[i]; //�Ѿ����������Σ���������һ��
            two = two | one & A[i]; //������1���ֳ�����1�Σ��ڼ�����ǰ�Ѿ�������2�εģ�Ϊ�µĳ�����2�ε�
            one = one | A[i]; //������1��
            one = one & ~three; //������3�ε������1��2��ȫ��Ĩȥ
            two = two & ~three;
        }
        return one;
    }
}
