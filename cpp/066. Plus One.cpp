#include<iostream>
#include<stdlib.h>
#include<vector>
using namespace std;

class Solution {
public:
	vector<int> plusOne(vector<int>& digits) {
		if (digits.size() == 0)
			return digits;
		int size = digits.size() - 1;
		digits[size] += 1;
		while (digits[size] == 10 && size != 0){
			digits[size] = 0;
			digits[size - 1] += 1;
			size--;
		}
		if (digits[0] == 10){
			digits[0] = 0;
			digits.insert(digits.begin(), 1);
		}
		return digits;
	}
};
int main(){
	Solution s;
	system("pause");
	return 0;
}
