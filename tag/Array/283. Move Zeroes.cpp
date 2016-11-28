class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        if(nums.size() < 2) return;
        int fir = 0;
        while(nums[fir] != 0 && fir < nums.size()) fir++;
        int sec = fir;
        while(fir < nums.size()){
            if(nums[fir] != 0) fir++;
            else{
                while(nums[sec] == 0){
                    sec++;
                    // the nail is full of zero
                    if(sec == nums.size()) return;
                }
                swap(nums[fir], nums[sec]);
                fir++;
            }
        }
    }
};