class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
    	sort(nums.begin(), nums.end());
    	vector<vector<int>> sets(1, vector<int>());
    	//iterative
    	for(int i = 0; i < nums.size(); i++){
    		int n = sets.size();
    		for(int j = 0; j < n; j++){
    			//push new number into existed subsets to make new subsets1
    			sets.push_back(sets[j]);
    			sets.back().push_back(nums[i]);
    		}
    	}
    	return sets;
        
    }
};
