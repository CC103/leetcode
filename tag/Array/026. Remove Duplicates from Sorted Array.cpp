class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() < 2) return nums.size();
        int first = 0;
        int second = 1;
        for(;second < nums.size();){
            if(nums[second] != nums[first]){
                int next = first + 1;
                if(second != next){
                    nums[next] = nums[second];
                }
                first++;
                second++;
            }
            else{
                second++;
            }
        }
        return first + 1;
    }
};