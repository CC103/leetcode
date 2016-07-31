class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
    	int left = 0, right = nums.size() - 1;
    	while(1){
    		int pos = partition(nums, left, right);
    		//pos + 1 = k; 
    		if(pos == k - 1)
    			return nums[pos];
    		else if(pos > k - 1)
    			right = pos - 1;
    		else
    			left = pos + 1;
    	}
    }
    int partition(vector<int>& nums, int left, int right){
    	int l = left + 1;
    	int r = right;
    	int pivot = nums[left];
    	while(l <= r){
    		if(nums[l] < pivot && nums[r] > pivot)
    			swap(nums[l++], nums[r--]);
    		if(nums[l] >= pivot)
    			l++;
    		if(nums[r] <= pivot)
    			r--;
    	}
    	//put pivot into the right position
    	//in the end of the loop, nums[l] <= pivot, nums[r]>= pivot
    	//pivot is the leftmost element so swap it with nums[r]
    	swap(nums[left], nums[r]);
    	//pivot is the r+1 th largest elemrnt
    	return r;
    }
};
