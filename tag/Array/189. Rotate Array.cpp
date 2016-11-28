class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.empty() || k < 0) return;
        int size = nums.size();
        k = k % size;
        vector<int> newNums(size);
        int i = 0;
        for(int j = size - k; j < size; i++, j++){
        	newNums[i] = nums[j];
        }
        for(int m = 0; i < size; i++, m++){
        	newNums[i] = nums[m];
        }
        for(int n = 0; n < size; n++){
        	nums[n] = newNums[n];
        }
    }
};