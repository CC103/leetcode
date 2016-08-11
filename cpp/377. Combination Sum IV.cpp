class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        vector<int> res(target + 1, 0);
        res[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int j : nums){
                if(i >= j)
                    //res[i - j]种情况每个加j得到i
                    res[i] += res[i - j];
            }
        }
        return res[target];
    }
};
