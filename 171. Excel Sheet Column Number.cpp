#include<iostream>
#include<math.h>
#include<string>
using namespace std;
class Solution {
public:
	int titleToNumber(string s) {
		int num = 0;
		int len = s.size();
		for (int i = 0; i < len; i++){
			int x = s[i] - 64;
			num += x * pow(26, (len - i - 1));
		}
		return num;
	}
};
