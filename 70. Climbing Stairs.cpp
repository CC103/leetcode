#include<iostream>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	int climbStairs(int n) {
		int res;
		if (n <= 2)
			return n;
		else{
			int *step = new int[n + 1];
			step[1] = 1;
			step[2] = 2;
			for (int i = 3; i < n + 1; i++){
				step[i] = step[i - 1] + step[i - 2];
			}
			int tmp = step[n];
			return tmp;
		}
	}
};
int main(){
	Solution s;
	for (int i = 0; i < 40; i++){
		cout << i << "  " << s.climbStairs(i) << endl;
	}
	system("pause");
	return 0;
}
