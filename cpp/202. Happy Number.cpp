#include<iostream>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	bool isHappy(int n) {
		int limit = 20;
		while (limit){
			int digitNum = 0;
			int arr[30] = {0};
			while (n > 0){
				arr[digitNum] = n - n / 10 * 10;
				digitNum++;
				n = n / 10;
			}
			int happyNum = 0;
			for (int i = 0; i < digitNum; i++)
				happyNum += arr[i] * arr[i];
			if (happyNum == 1)
				return true;
			n = happyNum;
			limit--;
		}
		return false;
	}
};
int main(){
	int a = 1;
	Solution s;
	cout << s.isHappy(a) << endl;
	system("pause");

}
