class Solution {
public:
    int rob(vector<int>& nums) {
    	int size = nums.size();
    	if(size < 2)
    		return size ? nums[0] : 0;
        return max(nums[0] + robsubset(nums, 2, size - 1), robsubset(nums, 1, size));
    }

    int robsubset(vector<int> &nums, int start, int end){
    	int pre = 0, cur = 0;
    	for(int i = start; i < end; i++){
    		int temp = max(cur, nums[i] + pre);
    		pre = cur;
    		cur = temp;

    	}
    	return cur;
    }
};
