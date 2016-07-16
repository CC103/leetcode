#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int bitNums [32] = {0};
        for(int i = 0; i < nums.size(); i++){
            for(int j = 31; j >= 0; j--){
                bitNums[j] += nums[i] & 1;
                nums[i] >>= 1;
                if(!nums[i])
                    break;
            }
        }
        int ret = 0;
        for(int i = 0; i < 32; i++){
            if(bitNums[i] % 3 != 0)
                ret += 1 << (31 - i);
        }
        return ret;
    }
};
