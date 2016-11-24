class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    	vector<int> ret;
        if(nums.empty()) return ret;
        vector<int> hash(100000, -1);
        for(int i = 0; i < nums.size(); i++){
        	hash[target - nums[i] + 50000] = i;
        }
        for(int i = 0; i < nums.size(); i++){
        	if(hash[nums[i] + 50000] >= 0 && hash[nums[i] + 50000] != i){
        		ret.push_back(i);
        		ret.push_back(hash[nums[i] + 50000]);
        		break;
        	}
        }
        return ret;

    }
};