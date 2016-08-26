class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int k = -1, l;
        int size = nums.size();
        for(int i = 0; i < size - 1; i++){
            if(nums[i] < nums[i + 1])
                 k = i;
        }
        if(k == -1){
            for(int i = 0; i < size / 2; i++){
                swap(nums[i], nums[size - i - 1]);
            }
            return;
        }
        l = k;
        for(int i = k + 1; i < size && nums[k] < nums[i]; i++){
            l = i;
        }
        swap(nums[k], nums[l]);
        int start = k + 1;
        int end = size - 1;
        while(start < end){
            swap(nums[start], nums[end]);
            start++;
            end--;
        }
    }
};
