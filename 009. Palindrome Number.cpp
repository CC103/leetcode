#include<iostream>

class Solution {
public:
	bool isPalindrome(int x) {
		if (x < 0)
			return false;
		int times = 1;
		while (x / times >= 10){
			times *= 10;
		}
		int low;
		int high;
		while (x != 0){
			low = x % 10;
			high = x / times;
			if (low != high)
				return false;
			x = x % times / 10;
			times /= 100;
		}
		return true;
	}
};
