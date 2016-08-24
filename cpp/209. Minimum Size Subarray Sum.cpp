class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        if(nums.empty())
            return 0;
        int sum = 0, start = 0, n = nums.size();
        int minLen = n + 1;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            while(sum >= s){
                minLen = min(minLen, i - start + 1);
                sum -= nums[start++];
            }
        }
        if(minLen == nums.size() + 1)
            return 0;
        return minLen;

    }
};
