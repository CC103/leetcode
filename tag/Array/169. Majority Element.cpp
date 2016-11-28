class Solution {
public:
    int majorityElement(vector<int>& nums) {
        stack<int> s;
        s.push(nums[0]);
        for(int i = 1; i < nums.size(); i++){
        	if(s.empty() || nums[i] == s.top()) s.push(nums[i]);
        	else s.pop();
        }
        return s.top();
    }
};