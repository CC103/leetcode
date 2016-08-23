class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.empty())
            return false;
        return jump(nums, 0);
    }

    bool jump(vector<int>& nums, int start){
        int maxLen = nums[start];
        if(start + maxLen >= nums.size() - 1)
            return true;
        //it can not be the last index now
        if(maxLen == 0)
            return false;
        for(int i = maxLen; i > 0; i--){
            if(jump(nums, start + i))
                return true;
        }
        return false;
    }
};
