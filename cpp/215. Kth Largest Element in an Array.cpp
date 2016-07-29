class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //insertion sort
        for(int i = 1; i < nums.size(); i++){
        	int key = nums[i];
        	int j = i - 1;
        	while(j >= 0 && nums[j] > key){
        		nums[j + 1] = nums[j];
        		j--;
        	}
        	nums[j + 1] = key;
        }

        return nums[nums.size() - k];
    }
};
