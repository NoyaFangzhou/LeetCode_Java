/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        // solution 1

        // current max profit in day i
        int max_cur = 0;
        // max profit for all these days with only one buy and sold
        int max_profit = 0;
        for(int i = 1; i<length; i++) {
            // max_cur here is the current max_profit before we do any operation at that day
            // the price difference is prices[i]-prices[i-1], this means that our profit is the profit we gain before + the price difference today
            max_cur = Math.max(0, max_cur-prices[i-1]+prices[i]);
            // then we find whether our today's profit is the largest among others because we are only allowed to do one buy and one sold
            max_profit = Math.max(max_cur, max_profit);
        }
        
        return max_profit;

        // solution 2
        if (prices.length == 0) {
             return 0 ;
         }      
         int max = 0 ;
         int sofarMin = prices[0] ;
         for (int i = 1 ; i < prices.length ; ++i) {
             if (prices[i] > sofarMin) {// can get profit
                 max = Math.max(max, prices[i] - sofarMin) ;
             } else{
                sofarMin = prices[i];  //
             }
         }       
        return  max ;
    }
}