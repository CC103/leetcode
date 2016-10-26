class Solution {
public:
    int thirdMax(vector<int>& nums) {
        if(nums.empty()) return 0;
        else if(nums.size() == 1) return nums[0];
        else if(nums.size() == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        else{
            // initialization 
            long fir = -2147483649;
            long sec = -2147483649;
            long thir = -2147483649;
            for(int i = 0; i < nums.size(); i++){
                if(nums[i] > fir){
                    thir = sec;
                    sec = fir;
                    fir = nums[i];
                }
                else if(nums[i] > sec && nums[i] < fir){
                    thir = sec;
                    sec = nums[i];
                }
                else if(nums[i] > thir && nums[i] < sec){
                    thir = nums[i];
                }
            }
            if(thir == -2147483649) return fir; 
            return thir;
        }
        
    }
};
