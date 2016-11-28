class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int, int> map;
        unordered_map<int, int>::iterator it;
        for(auto i : nums){
        	it = map.find(i);
        	if(it != map.end()) return true;
        	else map[i] = 1;
        }
        return false;
    }
};