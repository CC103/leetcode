#include <iostream>
#include <stdlib.h>
#include <vector>
using namespace std;

int main() {
	vector<int> nums = { 1, 2, 3, 0, 0, 5, 6, 0 };
	vector<int>::iterator it;
	int numofZero = 0;
	for (int i = 0; i < nums.size(); i++){
		if (nums[i] == 0) {
			nums.erase(nums.begin() + i);
			i--;
			numofZero++;
		}
	}
	for (int i = 0; i < numofZero; i++){
		nums.push_back(0);
	}
	for (it = nums.begin(); it != nums.end(); it++){
		cout << *it;
	}
	system("pause");
	return 0;
}
