#include<iostream>
class Solution {
public:
	int trailingZeroes(int n) {
		if (n == 0)
			return 0;
		int num = 0;
		while (n != 0){
			num += n / 5;
			n = n / 5;
		}
		return num;
	}
};
