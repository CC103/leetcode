class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
    	if(nums.size() < 3)
    		return nums.size();
        int cur = 0;
        int next = 2;
        for(cur = 0; cur < nums.size() - 2; next = cur + 2){
        	if(nums[next] == nums[cur]){
        		nums.erase(nums.begin() + next);
        	}
        	else
        		cur++;
        }
        return nums.size();
    }
};
