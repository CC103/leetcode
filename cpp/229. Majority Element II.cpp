class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        map<int, int> m;
        map<int, int>::iterator it;
        vector<int> ret;
        if(nums.empty())
        	return ret;
        int size = nums.size();
        for(auto n : nums){
        	it = m.find(n);
        	if(it != m.end())
        		it->second++;
        	else
        		m[n] = 1;
        }
        for(it = m.begin(); it != m.end(); it++){
        	if(it->second > size / 3)
        		ret.push_back(it->first);
        }
        return ret;
    }
};
