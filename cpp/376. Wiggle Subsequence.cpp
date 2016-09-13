class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        if(nums.empty())
            return 0;
        if(nums.size() == 1)
            return 1;
        vector<int> diff;
        for(int i = 0; i < nums.size() - 1; i++){
            int temp;
            temp = nums[i + 1] - nums[i];
            // 0 makes no difference
            if(temp != 0)
                diff.push_back(temp);
        }
        if(diff.empty())
            return 1;
        int size = diff.size();
        // delete nodes whch is not wiggle
        // diff here can not be empty here because if diff.size() = 0, "diff.size() - 1" will be unsigned number bug 
        for(int i = 0; i < diff.size() - 1; i++){
            if(diff[i] > 0 && diff[i + 1] > 0)
                size--;
            else if(diff[i] < 0 && diff[i + 1] < 0)
                size--;
        }
        return size + 1;
    }
};
