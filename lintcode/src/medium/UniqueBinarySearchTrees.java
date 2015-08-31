package medium;

/**
 * @author: decaywood
 * @date: 2015/8/31 15:37
 *
 * Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given n = 3, there are a total of 5 unique BST's.
 *
 * 1           3    3       2      1
 *  \         /    /       / \      \
 *   3       2    1       1   3      2
 *  /       /      \                  \
 * 2       1        2                  3
 *
 * ˼·�����㿨��������ʽ��
 * ��ȡһ������Ϊ����,Ȼ��������ο���ȡ0��N-1�����Ӧ��,�ұ���N-1��0��,����������,
 * ��h(0)*h(n-1) + h(2)*h(n-2) +  + h(n-1)h(0)=h(n)���ܹ���h(n)����
 *
 * ��h(0)=1,h(1)=1��catalan���������ʽ[1]  ��
 * h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)h(0) (n>=2)
 *
 * ���磺h(2)=h(0)*h(1)+h(1)*h(0)=1*1+1*1=2
 * h(3)=h(0)*h(2)+h(1)*h(1)+h(2)*h(0)=1*2+1*1+2*1=5
 *
 * �������ʽ[2]  ��
 * h(n)=h(n-1)*(4*n-2)/(n+1);
 *
 * ���ƹ�ϵ�Ľ�Ϊ��
 * h(n)=C(2n,n)/(n+1) (n=0,1,2,...)
 *
 * ���ƹ�ϵ�������Ϊ��
 * h(n)=c(2n,n)-c(2n,n-1)(n=0,1,2,...)
 *
 */
public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        if(n == 0 || n == 1) return 1;
        int previous = 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = previous * (4 * i - 2) / (i + 1);
            previous = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

}
