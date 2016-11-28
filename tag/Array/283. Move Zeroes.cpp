class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        if(nums.size() < 2) return;
        int fir = 0;
        while(fir < nums.size()){
        	if(nums[fir] != 0) fir++;
        	else{
        		int sec = fir;
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