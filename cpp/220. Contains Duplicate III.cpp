class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        set<int> window;
        for(int i = 0; i < nums.size(); i++){
            if(i > k){
                // keep the slice difference valid
                window.erase(nums[i - k - 1]);
            }
            // make sure *it >= nums[i] - t -> nums[i] - *it <= t
            auto it = window.lower_bound(nums[i] - t);
            // make sure nums[i] - *it >= -t
            if(it != window.end() && *it - nums[i] <= t) return true;
            else{
                window.insert(nums[i]);
            }
        }
        return false;
    }
};
