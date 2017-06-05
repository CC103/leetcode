public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, cur;
        if(prices.length == 0) return 0;
        else cur = prices[0];

        for(int i: prices) {
            if(i - cur > maxProfit) {
                maxProfit = i - cur;
                continue;
            }
            if(i < cur) cur = i;
        }

        return maxProfit;
    }
}
