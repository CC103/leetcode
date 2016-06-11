#include <iostream>
#include <string>
using namespace std;
class Solution {
public:
	string addBinary(string a, string b) {
		if (a.size() == 0 && b.size() == 0)
			return "0";
		int lenA = a.size();
		int lenB = b.size();
		int len = lenA > lenB ? lenA : lenB;
		if (lenA != lenB){
			if (len == lenA)
				b.insert(0, lenA - lenB, '0');
			if (len == lenB)
				a.insert(0, lenB - lenA, '0');
		}
		int carry = 0;
		string res;
		for (int i = len - 1; i >= 0; i--){
			int sum = (a[i] - 48) + (b[i] - 48) + carry;
			if (sum == 0){
				res.insert(0, 1, '0');
			}
			if (sum == 1){
				res.insert(0, 1, '1');
				carry = 0;
			}
			if (sum == 2){
				res.insert(0, 1, '0');
				carry = 1;
			}
			if (sum == 3){
				res.insert(0, 1, '1');
				carry = 1;
			}
		}
		if (carry == 1)
			res.insert(0, 1, '1');
		return res;
	}
};
