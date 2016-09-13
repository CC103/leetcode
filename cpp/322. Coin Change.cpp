class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(amount == 0 || coins.empty())
            return 0;
        sort(coins.begin(), coins.end());
        // there is potential risk here. If max = INT_MAX, there will be overflow 
        int max = amount + 1;
        vector<int> dp(amount + 1, max);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.size(); j++){
                if(i >= coins[j]){
                    dp[i] = dp[i] < dp[i - coins[j]] + 1 ? dp[i] : dp[i - coins[j]] + 1;
                }
                else
                    break;
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
        
    }
};
