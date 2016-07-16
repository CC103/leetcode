#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        if(nums[0] >= target)
            return 0;
        int size = nums.size();
        for(int i = 0; i < size - 1; i++){
            if(nums[i] == target)
                return i;
            if(nums[i] < target && nums[i + 1] > target)
                return i + 1;
        }
        if(nums[size - 1] == target)
            return size - 1;
        else
            return size;
    }
};
