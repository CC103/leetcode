#include<stack>
#include<iostream>
#include<vector>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	int majorityElement(vector<int>& nums) {
		stack<int> s;
		for (int i = 0; i < nums.size(); i++){
			int num = nums[i];
			if (s.empty())
				s.push(num);
			else{
				int stackTop = s.top();
				if (num == stackTop)
					s.push(num);
				else
					s.pop();
			}
		}
		return s.top();
	}
};

int main(){
	vector<int> v = { 1, 2, 1, 4, 1, 5, 1 , 8, 8, 8, 8, 8, 8};
	Solution s;
	int i = s.majorityElement(v);
	cout << i;
	system("pause");
	return 0;
}
