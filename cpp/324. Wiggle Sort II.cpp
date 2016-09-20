class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<int> sorted(nums);
        // divide thr array into two groups, pre and post
        // make the number of pre is equal or greater 1 than post
        for(int i = nums.size() - 1, pre = 0, post = i / 2 + 1; i >= 0; i--){
            // start with element of pre
            nums[i] = i & 1 ? sorted[post++] : sorted[pre++];
        }
    }
};
