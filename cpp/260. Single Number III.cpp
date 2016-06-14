#include<iostream>
#include<string>
#include<vector>
using namespace std;
class Solution {
public:
	vector<int> singleNumber(vector<int>& nums) {
		int allxor = 0;
		for (int n : nums){
			allxor ^= n;
		}
		int mask = allxor ^ (allxor & (allxor - 1));
		int one = 0;
		int zero = 0;
		for (int n : nums){
			if (n & mask)
				one ^= n;
			else
				zero ^= n;
		}
		vector<int> v;
		v.push_back(one);
		v.push_back(zero);
		return v;

	}
};
