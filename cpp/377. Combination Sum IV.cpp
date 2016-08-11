class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        int comNums = 0, sum = 0;
        sort(nums.begin(), nums.end());
        gen(comNums, sum, nums, target);
        return comNums;
          
    }
    void gen(int &comNums, int &sum, vector<int> &nums, int &target){
        for(int i : nums){
            sum += i;
            if(sum > target){
                sum -= i;
                return;
            }
            else if(sum == target){
                comNums++;
                sum -= i;
                return;
            }
            gen(comNums, sum, nums, target);
            sum -= i;
        }
    }
};
