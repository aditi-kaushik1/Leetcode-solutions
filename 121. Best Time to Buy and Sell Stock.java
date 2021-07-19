/* You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. */

class Solution {
    public int maxProfit(int[] prices) {
        //Solution 1
        //Time limit exceeded
        
//         int n = prices.length;
//         int max = 0;
        
//         for(int i = 0; i < n; i++) {
//             for(int j = i + 1; j < n; j++) {
//                 int diff = prices[j] - prices[i];
//                 max = Math.max(max, diff);
//             }
//         }
//         return max;
        
        //Solution 2
        //Using stacks
        
        int n = prices.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            if(prices[i] < min)
                min = prices[i];
            else
                max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
