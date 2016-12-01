class Solution {
public:
    int findPeakElement(vector<int>& nums) {
    	return binarySearch(nums, 0, nums.size() - 1);
    }
    int binarySearch(vector<int>& nums, int start, int end){
    	if(start == end) return start;
    	int mid1 = (start + end) / 2;
    	int mid2 = mid1 + 1;
    	if(nums[mid1] > nums[mid2]) return binarySearch(nums, start, mid);
    	else return binarySearch(nums, mid2, end);
    }
};