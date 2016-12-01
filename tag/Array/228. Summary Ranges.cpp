class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> ret;
        if(nums.empty()) return ret;
        // insert a flag of end
        nums.push_back(-1);
        for(int head = 0, nail = 0; nail < nums.size() - 1;){
        	if(nums[nail + 1] == nums[nail] + 1) nail++;
        	else{
        		if(head == nail){
        			ret.push_back(to_string(nums[head]));
        		}
        		else{
        			ret.push_back(to_string(nums[head]) + "->" + to_string(nums[nail]));
        		}
        		head = nail + 1;
        		nail = head;
        	}
        }
        return ret;
    }
};