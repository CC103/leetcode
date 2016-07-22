#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
    	int start = 0;
    	int end = nums.size() - 1;
    	int mid;
   		while(1){
   			if(nums[start] <= nums[end])
   				return nums[start];
   			mid = (start + end) / 2;
   			if(nums[mid] >= nums[start]){
   				//Increase 1 here is very important, it makes sure 'start' keeps moving
   				start = mid + 1;
   			}
   			else{
   				end = mid;
   			}
   		}
    }
};
