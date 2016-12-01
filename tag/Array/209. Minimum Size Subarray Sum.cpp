class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
    	if(nums.empty()) return 0;
        int sum = nums[0], len = INT_MAX;
        for(int head = 0, nail = 0; head < nums.size() && nail < nums.size();){
        	if(head > nail){
        		nail = head;
        		sum = nums[head];
        	}
        	if(sum < s){
        		nail ++;
        		if(nail < nums.size()) sum += nums[nail];
        	}
        	else{
        		int l = nail - head;
        		if(len > l) len = l;
        		sum -= nums[head];
        		head++;
        	}
        }
        if(len == INT_MAX) return 0;
        // length is nail - head + 1
        else return len + 1;

    }
};