class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int, int> hash;
        unordered_map<int, int>::iterator it;
        for(int i = 0; i < nums.size(); i++){
        	it = hash.find(nums[i]);
        	if(it == hash.end()){
        		hash[nums[i]] = i;
        	}
        	else{
        		if(i - it->second <= k) return true;
        		else it->second = i;
        	}
        }
        return false;
    }
};