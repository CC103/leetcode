class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
    	if(nums.empty()) return 0;
        int nail = nums.size() - 1;
        while(nums[nail] == val){
        	nail--;
        }
        for(int head = 0; head <= nail;){
        	if(nums[head] == val){
        		swap(nums[head], nums[nail]);
        		head++;
        		while(nums[nail] == val){
        			nail --;
        		}
        	}
        	else head++;
        }
        return nail + 1;
    }
};