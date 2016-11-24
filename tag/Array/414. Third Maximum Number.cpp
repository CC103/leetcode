class Solution {
public:
    int thirdMax(vector<int>& nums) {
        if(nums.size() == 1) return nums[0];
        if(nums.size() == 2) return max(nums[0], nums[1]);
        long first, sec, third;
        first = sec = third = long(INT_MIN) - 1;
        for(auto i : nums){
        	if(i > first){
        		long temp = first;
        		first = i;
        		third = sec;
        		sec = temp;	
        	}
        	else if(i > sec && i < first){
        		third = sec;
        		sec = i;
        	}
        	else if(i > third && i < sec){
        		third = i;
        	}

        }
        if(third == long(INT_MIN) - 1) return first;
        else return third;
    }
};