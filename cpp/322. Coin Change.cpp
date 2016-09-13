class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(amount == 0 || coins.empty())
            return 0;
        sort(coins.begin(), coins.end());
        int min = INT_MAX;
        dp(coins, amount, 0, min);
        return min == INT_MAX ? -1 : min;
    }
    void dp(vector<int> &coins, int amount, int num, int &min){
        //cout << "amount: " << amount << " " << "num: " << num << endl;
        if(amount < coins[0])
            return;
        for(auto i : coins){
            if(amount == i){
                min = min < num + 1 ? min : num + 1;
                return;
            }
            if(amount > i){
                dp(coins, amount - i, num + 1, min);
            }
            if(amount < i)
                return;
        }
    }
};
