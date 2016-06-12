#include<iostream>
#include<vector>
#include<string>
using namespace std;
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int size = nums.size();
        for(int i = 1; i <= k; i++){
            int j = nums[size - 1];
            nums.erase(nums.end() - 1);
            nums.insert(nums.begin(), j);
        }
    }
};
