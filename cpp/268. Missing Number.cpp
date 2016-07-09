#include<iostream>
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = 0;
        for(int i = 0; i < nums.size(); i++){
            if(n != nums[i])
                return n;
            n++;
        }
        return n++;
    }
};
