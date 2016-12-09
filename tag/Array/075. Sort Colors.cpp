class Solution {
public:
    void sortColors(vector<int>& nums) {
        int countR = 0, countW = 0, countB = 0;
        for (auto i : nums) {
        	if (i == 0) countR++;
        	else if (i == 1) countW++;
        	else countB++;
        }
        for(int i = 0; i < countR; i++){
        	nums[i] = 0;
        }
        int limit = countR + countW;
        for (int i = countR; i < limit; i++) {
        	nums[i] = 1;
        }
        for (int i = limit; i < nums.size(); i++) {
        	nums[i] = 2;
        }
    }
};