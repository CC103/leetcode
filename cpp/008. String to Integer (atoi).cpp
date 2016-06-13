#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
	int myAtoi(string str) {
		int i = 0;
		int result = 0;
		int max = 2147483647;
		int min = -2147483647 - 1;
		while (str[i] == ' '){
			i++;
		}
		bool symbol = true;
		if (str[i] == '+' || str[i] == '-'){
			if (str[i] == '-')
				symbol = false;
			i++;
		}
		for (; str[i] >= 48 && str[i] <= 57; i++){
			int digit = str[i] - '0';
			if (symbol){
				if (result > (max - digit) / 10)
					return max;
			}
			else{
				if (-result < (min + digit) / 10)
					return min;
			}
			result = result * 10 + digit;
		}
		return symbol ? result : -result;
	}
};
