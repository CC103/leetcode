class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
    	if(nums.empty()) return 0;
        int nail = nums.size() - 1;
        for(int head = 0; head <= nail;){
        	if(nums[head] == val){
        		swap(nums[head], nums[nail]);
        		nail --;
        	}
        	else head++;
        }
        return nail + 1;
    }
};