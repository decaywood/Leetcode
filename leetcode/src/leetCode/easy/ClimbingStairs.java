package leetCode.easy;

public class ClimbingStairs {

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * 
     * Each time you can either climb 1 or 2 steps. In how many distinct ways
     * can you climb to the top?
     * 
     * 爬楼梯问题实际就是斐波那契数列
     */
//    public int climbStairs(int n) {  //leetcode 上面超时
//        
//        if(n == 1)
//            return 1;
//        if(n == 2)
//            return 2;
//         
//        return climbStairs(n -1) + climbStairs(n - 2);
//        
//    }
    
    public int climbStairs(int n) {  //leetcode 上面超时
        
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        
        int num1 = 1;
        int num2 = 1;
        int sum = 0;
        for(int i = 1; i < n; i++){
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
         
        return sum;
        
    }
    
    
    
    public static void main(String[] args) {
        System.out.println( new ClimbingStairs().climbStairs(3));
    }
}
