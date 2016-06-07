#include<iostream>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	bool isUgly(int num) {
		if (num <= 0)
			return false;
		if (num == 1)
			return true;
		while (num != 1){
			if (num % 2 == 0){
				num = num / 2;
				continue;
			}
			if (num % 3 == 0){
				num = num / 3;
				continue;
			}
			if (num % 5 == 0){
				num = num / 5;
				continue;
			}
			return false;
		}
		return true;
	}
};

int main(){
	Solution s;
	for (int i = 0; i < 100; i++){
		cout << i << "  " << s.isUgly(i) << endl;
	}
	system("pause");
	return 0;
}
