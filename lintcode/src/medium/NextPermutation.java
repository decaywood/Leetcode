package medium;

/**
 * @author: decaywood
 * @date: 2015/9/1 19:30.
 *
 * Given a list of integers, which denote a permutation.
 *
 * Find the next permutation in ascending order.
 *
 * Example
 * For [1,3,2,3], the next permutation is [1,3,3,2]
 *
 * For [4,3,2,1], the next permutation is [1,2,3,4]
 *
 * Note
 * The list may contains duplicate integers.
 *
 * ˼·������Ѱ�ұȵ�ǰ����˳������һ�����С�
 *
 * �Ե�ǰ���дӺ���ǰɨ�裬�ҵ�һ��Ϊ���������Ԫ�أ���Ϊ i �� i+1��
 *
 * �������������һ��Ϊ���������Ԫ�أ����������о����ҵ����㷨������
 *
 * �������¶Ե�ǰ���дӺ���ǰɨ�裬�ҵ���һ������i��Ԫ��k������i��k��
 *
 * Ȼ��Դ�i + 1��ʼ�������������з�ת�����ʱ�õ��������о�Ϊ��һ���ֵ������С�
 *
 */
public class NextPermutation {

    public static int[] nextPermutation(int[] nums) {
        if (nums.length < 2) return nums;
        int i, k;
        for (i = nums.length - 2; i >= 0; i--) if (nums[i] < nums[i+1]) break;
        for (k = nums.length - 1; k > i && i >= 0; k--) if (nums[i] < nums[k]) break;
        if (i >= 0) swap(nums, i, k);
        reverse(nums, i + 1, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
        return nums;
    }

    private static void swap(int[] arr, int x, int y) {
        arr[x] ^= arr[y];
        arr[y] ^= arr[x];
        arr[x] ^= arr[y];
    }

    private static void reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            swap(arr, begin, end);
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1,2,1});
    }
}
