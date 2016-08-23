class Solution {
public:
    bool canJump(vector<int>& nums) {
        int size = nums.size();
        int pos = 0;
        for(int reach = 0; reach >= pos && pos < size; pos++){
            //update the largest range we can reach
            reach = max(pos + nums[pos], reach);
        }
        return pos == size;
    }
};
