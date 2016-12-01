class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
    	vector<int> ret;
    	if(nums.empty()) return ret;
        int m, n;
        for(int i = 0, countM = 0, countN = 0; i < nums.size(); i++){
        	
        	if(nums[i] == m){
        		countM++;
        	}
        	else if(nums[i] == n){
        		countN++;
        	}
        	else if(countM == 0){
        		m = nums[i];
        		countM++;
        	}
        	else if(countN == 0){
        		n = nums[i];
        		countN++;
        	}
        	else{
        		countN--;
        		countM--;
        	}
        }
        int size = nums.size() / 3;
        int countM = 0, countN = 0;
        for(int i = 0; i < nums.size(); i++){
        	if(nums[i] == m) countM++;
        	else if(nums[i] == n) countN++;
        }
        if(countM > size) ret.push_back(m);
    	if(countN > size) ret.push_back(n);
        return ret;
    }
};