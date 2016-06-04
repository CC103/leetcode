#include <iostream>
#include <stdlib.h>
class Solution {
public:
	bool isPowerOfThree(int n) {
		if (n <= 0)
			return false;
		if (n == 1)
			return true;
		else{
			while (n != 1){
				if (n % 3 != 0)
					return false;
				n = n / 3;
			}
		}
		return true;

	}
};

int main(){
	Solution s;
	std::cout << s.isPowerOfThree(81 * 81 * 80);
	system("pause");
	return 0;
}
