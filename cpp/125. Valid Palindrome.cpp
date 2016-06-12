#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
	bool isPalindrome(string s) {
		if (s.empty())
			return false;
		string sNew;
		for (int i = 0, j = s.size() - 1; i < j;){
			//number
			if (s[i] >= 48 && s[i] <= 57){
				if (s[j] >= 48 && s[j] <= 57){
					if (s[i] != s[j])
						return false;
					i++;
					j--;
					continue;
				}
				if ((s[j] >= 65 && s[j] <= 90) || (s[j] >= 97 && s[j] <= 122))
					return false;
				j--;
				continue;
			}
			//lower case
			if (s[i] >= 65 && s[i] <= 90){
				if (s[j] >= 65 && s[j] <= 90){
					if (s[i] != s[j])
						return false;
					i++;
					j--;
					continue;
				}
				if (s[j] >= 97 && s[j] <= 122){
					if (s[i] != s[j] - 32)
						return false;
					i++;
					j--;
					continue;
				}
				if (s[j] >= 48 && s[j] <= 57)
					return false;
				j--;
				continue;

			}
			//upper case
			if (s[i] >= 97 && s[i] <= 122){
				if (s[j] >= 97 && s[j] <= 122){
					if (s[i] != s[j])
						return false;
					i++;
					j--;
					continue;
				}
				if (s[j] >= 65 && s[j] <= 90){
					if (s[i] != s[j] + 32)
						return false;
					i++;
					j--;
					continue;
				}
				if (s[j] >= 48 && s[j] <= 57)
					return false;
				j--;
				continue;
			}
			i++;
			continue;
		}
		return true;
	}
};
