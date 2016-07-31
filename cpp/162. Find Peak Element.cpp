class Solution {
public:
    int findPeakElement(vector<int>& nums) {
    	if(nums.empty())
    		return -1;
    	if(nums.size() == 1)
    		return 0;
    	for(int i = 1; i < nums.size() - 1; i++){
    		if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
    			return i;
    	}
    	if(nums[0] > nums[1])
    		return 0;
    	int end = nums.size() - 1;
    	if(nums[end] > nums[end - 1])
    		return end;
      return -1;
    }
};
