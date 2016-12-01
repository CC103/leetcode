class Solution {
public:
    int findMin(vector<int>& nums) {
    	if(nums.empty()) return 0;
        int start = 0, end = nums.size() - 1, mid;
        if(nums[start] <= nums[end]) return nums[start];
        while(start < end){
        	mid = (start + end) / 2;
        	// pay attention when nums[mid] == nums[0]
        	// sucn like [2,1]
        	if(nums[mid] >= nums[0]) start = mid + 1;
        	else end = mid;
        }
        return nums[start];
    }
};