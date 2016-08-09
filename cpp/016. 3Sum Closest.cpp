class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        if(nums.size() < 3)
        	return 0;
        sort(nums.begin(), nums.end());
        int closet = nums[0] + nums[1] + nums[2];
        for(int first = 0; first < nums.size() - 2; first++){
        	int second = first + 1;
        	int last = nums.size() - 1;
        	while(second < last){
        		int temp = nums[first] + nums[second] + nums[last];
        		if(temp == target)
        			return temp;
        		if(abs(temp - target) < abs(closet - target)){
        			closet = temp;
        		}
        		if(temp > target)
        			last--;
        		else if(temp < target)
        			second++;
        	}
        }
        return closet;
        
    }
};
