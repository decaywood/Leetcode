package medium;

/**
 *  2014年11月15日
 *  @author decaywood
 *
 *  Write an efficient algorithm that searches for a value in an m x n matrix. 
 *  This matrix has the following properties:
 *    
 *  Integers in each row are sorted from left to right.
 *  The first integer of each row is greater than the last integer of the previous row.
 *  For example,
 *
 *  Consider the following matrix:
 *
 *  [
 *    [1,   3,  5,  7],
 *    [10, 11, 16, 20],
 *    [23, 30, 34, 50]
 *  ]
 *  Given target = 3, return true.
 *  
 *  
 *  解法1：二分法
 *  解法2：从右上或左下开始搜索，以右上为例，如果被搜索的元素大于target就减横坐标，
 *  如果小于target就减纵坐标，否则就是相等返回true
 *  
 */
public class SearchA2DMatrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int column = matrix[0].length;
        int row = 0;
        while(column > 0 && row < matrix.length){
            int value = matrix[row][column];
            if(target == value)
                return true;
            if(target < value)
                column--;
            else   
                row++;
        }
        return false;
    }
    
    public boolean binSearch(int array[], int start, int end, int target) {   
        
        if (start >= end)
            return false;
        
        int mid = (end + start) >> 1;   
        
        int midValue = array[mid];
        
        if(midValue == target)
            return true;
        
        if(target < midValue) 
            return binSearch(array, start, mid - 1, target);
        else
            return binSearch(array, mid + 1, end, target);
    } 

    public static void main(String[] args) {
        int[][] matrix = new int[2][];
        matrix[0] = new int[]{1};
        matrix[1] = new int[]{3};
        new SearchA2DMatrix().searchMatrix(matrix, 0);
    }
}
