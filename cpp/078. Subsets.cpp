class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
    	sort(nums.begin(), nums.end());
    	int n = pow(2, nums.size());
    	vector<vector<int>> sets(n, vector<int>());
    	for(int i = 0; i < nums.size(); i++){
    		for(int j = 0; j < n; j++){
    			//看子集对应二进制数j在i这一位上是否是1，若是1则装入nums[i]
    			if(j >> i & 1)
    				sets[j].push_back(nums[i]);
    		}
    	}
    	return sets;
        
    }
};
