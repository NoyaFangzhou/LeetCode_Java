/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        
        int length = prices.length;
        
        if (length <= 1) {
            return 0;
        }
        // init
        int[] buy = new int[2];
        int[] sold = new int[2];
        
        for(int i = 0; i<2; i++) {
            buy[i] = Integer.MIN_VALUE;
        }
        
        // 
        for(int price: prices) {
            for(int day = 1; day>=0; day--) {
                sold[day] = Math.max(sold[day], buy[day]+price);
                if (day != 0) {
                    buy[day] = Math.max(buy[day], sold[day-1]-price);
                }
                else {
                    buy[day] = Math.max(buy[day], -price);
                }
            }
        }
        
        return sold[1];
        
    }

    // general solution for this question, but it requires that this k should be a proper number
    // otherwise it will rasie an Memory Limited Excceed exception!
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (length <= 1 || k == 0) {
            return 0;
        }
        
        int[] buy = new int[k];
        int[] sold = new int[k];
        
        for(int i = 0; i<k; i++) {
            buy[i] = Integer.MIN_VALUE;
        }
        
        for(int p: prices) {
            for(int j = k-1; j>=0; j--) {
                sold[j] = Math.max(sold[j], buy[j]+p);
                if (j == 0) {
                    buy[j] = Math.max(buy[j], -p);
                }
                else {
                    buy[j] = Math.max(buy[j], sold[j-1]-p);
                }
            }
        }
        
        return sold[k-1];
    }
}