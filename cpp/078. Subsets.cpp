class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
    	sort(nums.begin(), nums.end());
    	vector<vector<int>> sets;
    	vector<int> set;
    	findSubsets(sets, set, nums, 0);
    	return sets;
        
    }

    //find all distinct subsets whose range begin with 'begin' 
    void findSubsets(vector<vector<int>>& sets, vector<int>& set, vector<int>& nums, int begin){
    	sets.push_back(set);
    	for(int i = begin; i < nums.size(); i++){
    		set.push_back(nums[i]);
    		findSubsets(sets, set, nums, i + 1);
    		set.pop_back();
    	}
    }
};
