class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int size = nums.size();
        if(nums.size() == 1) return 0;
        for(int i = 0; i < size - 1; i++){
        	if(nums[i] > nums[i + 1]) return i;
        }
        return size - 1;
    }
};