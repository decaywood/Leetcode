package leetcode.medium;

public class SingleNumberII {

    /**
     * Given an array of integers, every element appears three times except for
     * one. Find that single one.
     * 
     * Note: Your algorithm should have a linear runtime complexity. Could you
     * implement it without using extra memory?
     */

    /**
     * 思路：
     * 回顾SingleNumberI:
     * 其实是一个小技巧。一个整数和它本身异或之后得到值是0。所以初始化一个值为0的变量，
     * 让数组中的所有数与之异或，然后就可以找到这个只出现一次的数。
     * 
     * 题目可以扩展到寻找唯一的一个只出现奇数次的数。一样的方法。
     * 
     * 对于第二个问题，因为只能用O(1)的空间，所以技巧是对每一个位的1的个数进行计数。这样唯一的只出现一次的数用到的位将导致计数不是3的倍数。
     * 最后检查所有计数不是3倍数的位，即可恢复原来的数字。
     */
    public int singleNumber(int[] A) {
        
        int time1 = 0;
        int time2 = 0;
        int time3 = 0;
        for (int i : A) {
            time3 = time2 & i; //已经出现两次并且再次出现 
            time2 |= time1 & i; //曾经出现两次的或者曾经出现一次但是再次出现的  
            time1 |= i;  //出现一次的  
            time1 &= ~time3; //当某一位出现三次后，我们就从出现一次中消除该位  
            time2 &= ~time3; //当某一位出现三次后，我们就从出现两次中消除该位  
        }
        return time1;
    }
   

    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[] { 1, 1,
                1, 2, 3, 3, 3 }));
    }
}
