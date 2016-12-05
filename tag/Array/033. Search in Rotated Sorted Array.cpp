class Solution {
public:
    int search(vector<int>& nums, int target) {
    	if(nums.empty()) return -1;
        int start = 0, end = nums.size() - 1, mid, min;
        if (nums[start] <= nums[end]) {
        	return bs(nums, 0, nums.size() - 1, target);
        }
        else {
        	while (start < end){
	        	mid = (start + end) / 2;
	        	if (nums[mid] >= nums[0]) start = mid + 1;
	        	else end = mid;
        	}
        	min = end;
        }
        if (target >= nums[0]) return bs(nums, 0, min - 1, target);
        else if (target <= nums[nums.size() - 1]) return bs(nums, min, nums.size() - 1, target);
        else return -1;
    }

    int bs(vector<int> &nums, int start, int end, int target){
    	int mid;
    	while (start <= end){
    		mid = (start + end) / 2;
        	if (nums[mid] == target) {
        		return mid;
        	}
        	else if (nums[mid] > target) end = mid - 1;
        	else start = mid + 1;
    	}
    	return -1;
    }
};