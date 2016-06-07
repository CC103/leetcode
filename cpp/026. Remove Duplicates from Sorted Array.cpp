#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() <= 1)
            return nums.size();
        int len = 1;
        int size = nums.size();
        for(int i = 0; i < size - 1; i++){
            if(nums[i + 1] != nums[i]){
                nums[len++] = nums[i + 1];
            }
        }
        return len;
    }
    
};
int main(){
	Solution s;
	vector<int> v;
	v.push_back(1);
	v.push_back(1);
	s.removeDuplicates(v);
	cout << v[0];
}
