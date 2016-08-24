class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        if(nums.empty())
            return 0;
        vector<int> subArray;
        int sum = 0;
        int i = 0;
        int minLen = nums.size() + 1;
        while(i <= nums.size()){
            if(sum > s){
                minLen = subArray.size() < minLen ? subArray.size() : minLen;
                sum -= subArray[0];
                subArray.erase(subArray.begin());
            }
            else if(sum < s){
                if(i == nums.size())
                    break;
                subArray.push_back(nums[i]);
                sum += nums[i];
                i++;
            }
            else{
                minLen = subArray.size() < minLen ? subArray.size() : minLen;
                if(i == nums.size())
                    break;
                sum -= subArray[0];
                subArray.erase(subArray.begin());
                subArray.push_back(nums[i]);
                sum += nums[i];
                i++;
            }
        }
        if(minLen == nums.size() + 1)
            return 0;
        return minLen;

    }
};
