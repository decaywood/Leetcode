package dataStructure;

/**
 * @author: decaywood
 * @date: 2016/1/26 17:52
 */
public class Matrix {

    public static int[][] generateTestCase(String string) {

        String[] arr = string.substring(2, string.length() - 2).split("\\],\\[");
        int[][] matrix = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            String[] nums = s.split(",");
            int[] ints = new int[nums.length];
            matrix[i] = ints;
            for (int j = 0; j < nums.length; j++) {
                int n = Integer.parseInt(nums[j]);
                ints[j] = n;
            }
        }
        return matrix;
    }


}
