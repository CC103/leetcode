class Solution {
public:
    int minMoves(vector<int>& nums) {
        // non-empty
        // if(nums.empty()) return 0;
        int max = INT_MIN;
        int maxIndex = -1;
        int step = 0;
        while(!check(nums)){
            step++;
            for(int i = 0; i < nums.size(); i++){
                if(max < nums[i]){
                    max = nums[i];
                    maxIndex = i;
                }
                if(nums[i] != INT_MAX) nums[i]++;
            }
            if(max != INT_MAX) nums[maxIndex]--;
        }
        return step;
    }
    bool check(vector<int>& v){
        for(int i = 0; i < v.size() - 1; i++){
            if(v[i] != v[i + 1]) return false;
        }
        return true;
    }
};
