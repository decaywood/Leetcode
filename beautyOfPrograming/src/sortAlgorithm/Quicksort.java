package sortAlgorithm;

/**
 * @author: decaywood
 * @date: 2015/8/18 16:24
 */
public class Quicksort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if(left >= right) return;
        int mid = partition(array, left, right);
        quickSort(array, left, mid - 1);
        quickSort(array, mid + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int key = array[left];
        while (left < right){
            while (left < right && array[right] >= key) right--;
            array[left] = array[right];
            while (left < right && array[left] < key) left++;
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }

    public static void main(String[] args) {
        quickSort(new int[]{1,5,3});
    }


}
