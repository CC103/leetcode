class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if(nums.empty())
            return 0;
        int maxSoFar = nums[0];
        int maxPre = nums[0], minPre = nums[0];
        // including current number
        int maxHere, minHere;
        for(int i = 1; i < nums.size(); i++){
            maxHere = max(max(maxPre * nums[i], minPre * nums[i]), nums[i]);
            minHere = min(min(maxPre * nums[i], minPre * nums[i]), nums[i]);
            maxSoFar = max(maxHere, maxSoFar);
            maxPre = maxHere;
            minPre = minHere;
        }
        return maxSoFar;
    }
};
