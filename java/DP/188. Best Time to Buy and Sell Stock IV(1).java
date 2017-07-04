public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k >= prices.length / 2) {
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }

        // dp[i, j] represents the max profit up until prices[j] using at most i transactions.
        int dp[][] = new int[k + 1][prices.length];

        for(int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];

            for(int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][prices.length - 1];
    }
}
