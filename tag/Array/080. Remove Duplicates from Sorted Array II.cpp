class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() < 3) return nums.size();
        int fir = 0, sec = 1, next;
        bool isDuplicated = false;
        for(; sec < nums.size();){
        	next = fir + 1;
        	if(nums[sec] != nums[fir]){
        		if(sec == next){
        			fir = next;
        			sec++;
        		}
        		else{
        			nums[next] = nums[sec];
        			fir = next;
        			sec++;
        		}
        		isDuplicated = false;
        	}
        	else{
        		if(!isDuplicated){
        			nums[next] = nums[sec];
        			fir++;
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