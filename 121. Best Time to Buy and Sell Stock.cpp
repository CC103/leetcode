#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
	int maxProfit(vector<int>& prices) {
		if (prices.empty())
			return 0;
		int maxProfit = 0;
		int min = prices[0];
		for (int i = 1; i < prices.size(); i++){
			if (prices[i] - min > maxProfit)
				maxProfit = prices[i] - min;
			if (prices[i] < min)
				min = prices[i];
		}
		return maxProfit;
	}
};
