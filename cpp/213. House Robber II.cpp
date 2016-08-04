class Solution {
public:
    int rob(vector<int>& nums) {
    	if(nums.empty())
    		return 0;
    	if(nums.size() == 1)
    		return nums[0];
    	if(nums.size() == 2)
    		return max(nums[0], nums[1]);
        vector<int> m(nums);
        vector<int> n(nums);
        //m: rob the first house, erase nums[0], nums[1], nums[size- 1]
        m.erase(m.begin());
        //size has changed
        m.erase(m.begin());
        m.erase(m.end() - 1);
        //n: not rob the first house
        n.erase(n.begin());
        int mprofit = nums[0] + robsubset(m);
        int nprofit = robsubset(n);
        return max(mprofit, nprofit);
    }

    int robsubset(vector<int> &nums){
    	vector<int> profit(nums.size(), 0);
    	if(nums.size() == 0)
    		return 0;
    	if(nums.size() == 1)
    		return nums[0];
    	vector<int> dp(nums.size(), 0);
    	dp[0] = nums[0];
    	dp[1] = max(nums[0], nums[1]);
    	for(int i = 2; i < nums.size(); i++){
    		dp[i] = max(nums[i] + dp[i - 2], dp[i - 1]);
    	}
    	return dp[nums.size() - 1];
    }
};
