class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int, vector<int>> hash;
        unordered_map<int, vector<int>>::iterator it;
        for(int i = 0; i < nums.size(); i++){
        	it = hash.find(nums[i]);
        	if(it == hash.end()){
        		vector<int> v(1, i);
        		hash[nums[i]] = v;
        	}
        	else{
        		for(int j = 0; j < it->second.size(); j++){
        			if(i - it->second[j] <= k) return true;
        		}
        		it->second.push_back(i);
        	}
        }
        return false;
    }
};