class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int size = nums.size();
        vector<int> pre(size, 1);
        vector<int> post(size, 1);
	    for (int i = 0, j = 1; j < size; ++i, ++j)
	    {
	    	pre[j] = pre[j - 1] * nums[i];
	    }
	    for (int i = size - 1, j = size - 2; j >= 0; --i, --j)
	    {
	    	post[j] = post[j + 1] * nums[i];
	    }
	    for (int i = 0; i < size; ++i)
	    {
	    	pre[i] *= post[i];
	    }
	    return pre;
    }
};