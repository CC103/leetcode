#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> result;
        recursivePermute(nums, 0, result);
        return result;
    }

    void recurPermute(vector<int>& nums, int begin, vector<vector<int>>& result){
    	if(begin >= nums.size()){
    		result.push_back(nums);
    		return;
    	}
    	for(int i = begin; i < nums.size(); i++){
    		swap(nums.begin(), nums.begin() + i);
    		recurPermute(nums, begin + 1, result);
    		swap(nums.begin(), nums.begin() + i);
    	}
    }
};
