#include<iostream>
#include<string>
#include<vector>
using namespace std;

class Solution {
public:
	vector<int> countBits(int num) {
		vector<int> v;
		for (int i = 0; i <= num; i++){
			int n = i;
			int nums = 0;
			while (n != 0){
				n = n & (n - 1);
				nums++;
			}
			v.push_back(nums);
		}
		return v;
	}
};
