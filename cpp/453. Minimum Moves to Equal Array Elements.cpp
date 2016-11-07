class Solution {
public:
    int minMoves(vector<int>& nums) {
        if(nums.size() < 2) return 0;
        int minum = nums[0];
        long sum = nums[0];
        for(int i = 1; i < nums.size(); i++){
            minum = min(nums[i], minum);
            sum += nums[i];
        }
        return sum - long(minum) * long(nums.size());
    }
};
