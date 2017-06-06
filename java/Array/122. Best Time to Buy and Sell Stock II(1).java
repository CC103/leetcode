// Peak Valley Approach

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, valley, peak;

        for(int i = 0; i < prices.length - 1; i++) {
            // find valley
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];

            // find peak
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];

            profit += peak - valley;
        }
        return profit;
    }
}
