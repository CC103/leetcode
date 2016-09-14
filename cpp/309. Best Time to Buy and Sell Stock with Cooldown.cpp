class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buy = INT_MIN, preBuy = 0;
        int sell = 0, preSell = 0;
        for(auto price : prices){
            preBuy = buy;
            buy = max(preSell - price, preBuy);
            preSell = sell;
            sell = max(preBuy + price, sell);
        }
        return sell;
    }
};
