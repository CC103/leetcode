class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
    	nums.push_back(0);
        for(int i = 0; i < nums.size(); i++){
        	while(nums[i] != i){
        		if(nums[i] == nums[nums[i]]) break;
        		swap(nums[i], nums[nums[i]]);
        	}
        }
        vector<int> ret;
        for(int i = 0; i < nums.size(); i++){
        	if(nums[i] != i) ret.push_back(i);
        }
        return ret;
    }
};