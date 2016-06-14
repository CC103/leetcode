#include<iostream>
#include<vector>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	int maxProfit(vector<int>& prices) {
		int profit = 0;
		int len = prices.size();
		for (int i = 0; i < (len - 1); i++){
			if (prices[i + 1] > prices[i])
				profit += prices[i + 1] - prices[i];
		}
		return profit;
	}
};
int main(){
	vector<int> v;
	Solution s;
	cout << s.maxProfit(v);
	system("pause");
	return 0;
}
