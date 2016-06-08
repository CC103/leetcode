#include<iostream>
#include<vector>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	bool containsNearbyDuplicate(vector<int>& nums, int k) {
		int arr[1000000] = {0};
		for (int i = 0; i < nums.size(); i++){
			if (nums[i] < 0){
				nums[i] = nums[i] + 1000000;
			}
			if (arr[nums[i]] == 0){
				//因为arr初始化为0，所以下标要从1开始
				arr[nums[i]] = i + 1;
			}
			else{
				int diff = i + 1 - arr[nums[i]];
				if (diff <= k)
					return true;
				arr[nums[i]] = i + 1;
			}
		}
		return false;
	}
};

int main(){
	vector<int> v = { 1 };
	Solution s;
	cout << s.containsNearbyDuplicate(v, 1);
	system("pause");
	return 0;
}
