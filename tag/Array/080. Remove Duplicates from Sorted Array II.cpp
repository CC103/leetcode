class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() < 3) return nums.size();
        int fir = 0, sec = 1, next;
        bool isDuplicated = false;
        for(; sec < nums.size();){
        	if(nums[sec] != nums[fir]){
        		next = fir + 1;
        		if(sec != next){
        			nums[next] = nums[sec];
        			fir++;
        			sec++;
        			isDuplicated = false;
        		}
        		else{
        			fir++;
        			sec++;
        			isDuplicated = false;
        		}
        	}
        	else{
        		if(!isDuplicated){
        			// make the second same element
        			nums[fir + 1] = nums[sec];
        			fir++;
        			sec++;
        			isDuplicated = true;
        		}
        		else{		
        			sec++;
        		}
        		
        	}
        }
        return fir + 1;
    }
};