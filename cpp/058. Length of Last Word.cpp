#include<iostream>
#include<string>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	int lengthOfLastWord(string s) {
		int len = 0;
		int last;
		for (int i = 0; i < s.size(); i++){
			if (s[i] == ' ' && len != 0){
				last = len;
				len = 0;
				continue;
			}
			else if (s[i] != ' '){
				len++;
			}
		}
		if (len != 0)
			last = len;
		return last;
	}
};

int main(){
	Solution s;
	string str = "a      adf  sd  adsf";
	cout << s.lengthOfLastWord(str);
	system("pause");
	return 0;
}
