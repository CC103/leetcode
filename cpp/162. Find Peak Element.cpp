class Solution {
public:
    int findPeakElement(vector<int>& nums) {
    	//empty nums is unvalid
		if(nums.size() == 1)
    		return 0;
    	//the last time of loop didn't return only because nums[i] > nums[i - 1]
    	//so there is no need to compare nums[i] and nums[i - 1]
    	for(int i = 0; i < nums.size() - 1; i++){
    		if(nums[i] > nums[i + 1])
    			return i;
    	}
    	return nums.size() - 1;
    }
};
