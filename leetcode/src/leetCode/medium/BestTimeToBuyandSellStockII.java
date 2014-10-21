package leetCode.medium;

public class BestTimeToBuyandSellStockII {
    
    /**
     * Say you have an array for which the ith element is the price of a given
     * stock on day i. Design an algorithm to find the maximum profit. You may
     * complete as many transactions as you like (ie, buy one and sell one share
     * of the stock multiple times). However, you may not engage in multiple
     * transactions at the same time (ie, you must sell the stock before you buy
     * again).
     * 
     */
    
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length == 1)
            return 0;
        int maxProfit = 0;
        for(int i = 0; i < prices.length -1; i++){  // 如果预计股票会涨价，直接买入
            int day1 = prices[i];                   // 下跌则不交易
            int day2 = prices[i+1];
            maxProfit += Math.max(0, day2 - day1); 
        }
        return maxProfit;
    }

}
