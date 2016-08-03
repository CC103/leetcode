class Solution {
public:
    int hIndex(vector<int>& citations) {
  		// case 1: citations[mid] == len-mid, then it means there are citations[mid] papers that have at least citations[mid] citations.
		  // case 2: citations[mid] > len-mid, then it means there are citations[mid] papers that have moret than citations[mid] citations, so we should continue searching in the left half
		  // case 3: citations[mid] < len-mid, we should continue searching in the right side
    	int left = 0;
    	int right = citations.size() - 1;
    	int len = citations.size();
    	int mid;
    	while(left <= right){
    		mid = (left + right) >> 1;
    		int nums = len - mid - 1;
    		if(citations[mid] == nums)
    			return citations[mid];
    		else if(citations[mid] > nums)
    			right = mid - 1;
    		else
    			left = mid + 1;
    	}
    	//I can't make logical proof but it's true 
    	return len - (right + 1);

    }
};
