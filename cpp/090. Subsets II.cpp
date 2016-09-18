class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ret;
        if(nums.empty())
            return ret;
        vector<int> subset;
        ret.push_back(subset);
        for(int i = 0; i < nums.size();){
            // the number of duplicates
            // count = 1 if there is no duplicates of nums[i]
            int count = 0;
            while( i + count < nums.size() && nums[i] == nums[i + count]){
                count++;
            }
            // ret is changing in the process, so we need record the size first
            int size = ret.size();
            for(int j = 0; j < size; j++){
                vector<int> instance = ret[j];
                for(int m = 0; m < count; m++){
                    instance.push_back(nums[i]);
                    ret.push_back(instance);
                }
            }
            i = i + count;
        }
        return ret;

    }
};
