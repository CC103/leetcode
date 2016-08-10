class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int start = 0;
        int end = nums.size() - 1;
        int mid;
        vector<int> ret(2, -1);
        while(start <= end){
            mid = (start + end) / 2;
            if(nums[mid] < target)
                start = mid + 1;
            else if(nums[mid] > target)
                end = mid - 1;
            else{
                ret[0] = findLowBound(nums, target, start, mid);
                ret[1] = findHighBound(nums, target, mid, end);
                break;
            }
        }
        return ret;
    }

    int findLowBound(vector<int>& nums, int target, int start_, int end_){
        int start = start_;
        int end = end_;
        while(start < end){
            int mid = (start + end)/2;
            if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        if(nums[start] < target)
            start++;
        return start;
    }
    int findHighBound(vector<int>& nums, int target, int start_, int end_){
        int start = start_;
        int end = end_;
        while(start < end){
            int mid = (start + end)/2;
            if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        if(nums[start] > target)
            start--;
        return start;
    }
};
