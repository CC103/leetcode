class Solution {
public:
    void sortColors(vector<int>& nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        //count number of 0, 1 and 2
        for(int i = 0; i < nums.size(); i++){
        	switch(nums[i]){
        		case 0: num0++;
        		case 1: num1++;
        		case 2: num2++;
        	}
        }
        //overwrite array with total number of 0's, 1's and 2's
        for(int i = 0; i < num0; i++){
        	nums[i] = 0;
        }
        for(int i = num0; i < num1; i++){
        	nums[i] = 1;
        }
        for(int i = num1; i < num2; i++){
        	nums[i] = 2;
        }
    }
};
