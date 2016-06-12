#include<iostream>
#include<vector>
#include<stdlib.h>
using namespace std;
class NumArray {
public:
	NumArray(vector<int> &nums) {
		int sum = 0;
		for (int i = 0; i < nums.size(); i++){
			sum += nums[i];
			arr[i] = sum;
		}
	}

	int sumRange(int i, int j) {
		if (i == 0)
			return arr[j];
		return arr[j] - arr[i - 1];
	}
private:
	int arr[10000];
};
int main(){
	vector<int> v = { -2, 0, 3, -5, 2, -1 };
	NumArray numarray(v);
	cout << numarray.sumRange(0, 5);
	system("pause");
	return 0;

}
