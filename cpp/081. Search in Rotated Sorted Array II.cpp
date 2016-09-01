class Solution {
public:
    int search(vector<int>& nums, int target) {
        for(int i : nums){
            if(i == target)
            return true;
        }
        return false;
    }
};
