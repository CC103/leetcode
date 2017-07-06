public class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = Integer.MIN_VALUE, preSell = 0, preBuy;

        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);

            preSell = sell;
            sell = Math.max(preBuy + price, preSell);
        }

        return sell;

    }
}
