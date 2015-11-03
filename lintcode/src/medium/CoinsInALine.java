package medium;

/**
 * @author: decaywood
 * @date: 2015/10/24 10:42.
 *
 * There are n coins in a line.
 * Two players take turns to take one or two coins from right side until there are no more coins left.
 * The player who take the last coin wins.
 *
 * Could you please decide the first play will win or lose?
 *
 * Example
 * n = 1, return true.
 * n = 2, return true.
 * n = 3, return false.
 * n = 4, return true.
 * n = 5, return true.
 *
 * Challenge
 * O(n) time and O(1) memory
 *
 */
public class CoinsInALine {


    /**
     * 思路：一个人最多可以取2个coin，就是说如果留给对方的是3个coin, 我就能赢（对方取coin的时候剩下3个）
     * 为了让对方取的时候是3个coin，策略是
     * 1. 我首先取，并且取完后的数目时3的倍数
     * 2. 然后是对方取X，接着我取的数目是3-X
     * 3. 这样能保证当对方取的时候是3的倍数
     */
    public boolean firstWillWin(int n) {
        return n % 3 != 0;
    }

}
