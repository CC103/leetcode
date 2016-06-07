#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
	bool containsDuplicate(vector<int>& nums) {
		int f[1000000] = { 0 };
		for (int i = 0; i < nums.size(); i++){
			if (f[nums[i]] == 0)
				f[nums[i]] = 1;
			else
				return true;
		}
		return false;
	}
};
