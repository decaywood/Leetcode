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
 * 思路：满足卡特兰递推式：
 * 先取一个点作为顶点,然后左边依次可以取0至N-1个相对应的,右边是N-1到0个,两两配对相乘,
 * 即h(0)*h(n-1) + h(2)*h(n-2) +  + h(n-1)h(0)=h(n)（能构成h(n)个）
 *
 * 令h(0)=1,h(1)=1，catalan数满足递推式[1]  ：
 * h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)h(0) (n>=2)
 *
 * 例如：h(2)=h(0)*h(1)+h(1)*h(0)=1*1+1*1=2
 * h(3)=h(0)*h(2)+h(1)*h(1)+h(2)*h(0)=1*2+1*1+2*1=5
 *
 * 另类递推式[2]  ：
 * h(n)=h(n-1)*(4*n-2)/(n+1);
 *
 * 递推关系的解为：
 * h(n)=C(2n,n)/(n+1) (n=0,1,2,...)
 *
 * 递推关系的另类解为：
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
