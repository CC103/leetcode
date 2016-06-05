#include<iostream>
#include<vector>
#include<algorithm>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	int rob(vector<int>& nums) {
		if (nums.empty())
			return 0;
		if (nums.size() == 1)
			return nums[0];
		int dp[1000] = { 0 };
		dp[0] = nums[0];
		dp[1] = max(nums[1], dp[0]);
		for (int i = 2; i < nums.size(); i++){
			dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.size() - 1];
	}
};

int main(){
	Solution s;
	vector<int> v;
	v.push_back(1);
	v.push_back(2);
	int res = s.rob(v);
	cout << res;
	system("pause");
	return 0;
}
