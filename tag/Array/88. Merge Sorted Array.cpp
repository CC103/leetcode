class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
    	int len = m + n;
    	vector<int> temp(len);
    	int p1 = 0, p2 = 0, i = 0;
    	while(p1 < m || p2 < n){
    		if(p2 == n) temp[i++] = nums1[p1++];
    		else if(p1 == m) temp[i++] = nums2[p2++];
    		else{
    			temp[i++] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
    		}
    	}
    	for(int i = 0; i < len; i++){
    		nums1[i] = temp[i];
    	}
    }
};