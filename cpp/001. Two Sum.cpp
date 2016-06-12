#include<iostream>
#include<unordered_map>
#include<vector>
using namespace std;
class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		unordered_map<int, int> myMap;
		vector<int> result;
		for (int i = 0; i < nums.size(); i++){
			if (myMap.find(nums[i]) == myMap.end()){
				myMap[target - nums[i]] = i;
			}
			else{
				result.push_back(myMap[nums[i]]);
				result.push_back(i);
				break;
			}
		}
		return result;
	}
};
