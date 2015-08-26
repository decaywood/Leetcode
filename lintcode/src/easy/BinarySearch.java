package easy;

/**
 * @author: decaywood
 * @date: 2015/8/26 21:27.
 *
 * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
 *
 * If the target number does not exist in the array, return -1.
 *
 * Example
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 *
 * Challenge
 * If the count of numbers is bigger than 2^32, can your code work properly?
 *
 */
public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left < right) {
            int middle = (left + right) / 2;
            int num = nums[middle];
            if(right - left <= 2 || num == target) {
                index = nums[left] == target ? left : nums[middle] == target ? middle : right;
                break;
            }
            left = num > target ? left : middle + 1;
            right = num > target ? middle - 1 : right;
        }
        if(nums[index] != target) return -1;
        while (index - 1 >= 0 && nums[index - 1] == nums[index]) index--;
        return index;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{7,20,20,21,22,23,23,24,25,26,27,27,34,34,36,36,38,38,38,40,41,42,44,46,47,48,49,49,51,53,54,57,58,59,59,60,61,61,61,62,63,64,65,66,66,67,71,72,74,74,74,75,76,77,78,78,79,83,85,85,89,89,93,93,95,95,95,96,97,97,99,99,100,101,101,101,102,105,105,106,108,108,111,113,114,116,117,117,117,118,119,120,122,123,125,126,126,127,127,129,129,130,131,131,133,134,135,135,135,139,140,140,143,143,143,144,149,149,150,150,151,152,152,153,154,154,156,156,157,160,161,161,161,165,170,170,171,172,173,174,176,177,178,180,181,181,182,184,184,186,187,187,189,190,192,194,196,197,198,199,199,200,201,203,203,204,204,204,204,204,204,205,207,208,209,209,210,210,211,211,212,212,215,216,216,217,223,224,224,224,224,225,227,227,229,229,230,231,235,235,235,236,237,238,238,238,238,240,240,241,241,242,244,244,245,246,249,249,249,250,251,253,254,256,256,257,257,260,261,261,263,267,268,268,269,270,270,270,270,271,271,272,273,274,275,276,276,277,279,280,282,282,284,284,286,286}, 286));
    }


}
