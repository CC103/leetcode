#include<sstream>
#include<string>
#include<iostream>
#include<stdlib.h>
using namespace std;

class Solution {
public:
	string calculate(string s){
		string res;
		string tmp;
		stringstream ss;
		int len = 0;
		for (int i = 0; i < s.size(); i++){
			if (i == 0){
				len++;
				continue;
			}
			if (s[i] == s[i - 1]){
				len++;
				continue;
			}
			else{
				ss << len;
				ss >> tmp;
				ss.clear();
				ss.str("");
				//放入x出现的次数
				res += tmp;
				//放入x
				res.push_back(s[i - 1]);
				len = 1;
			}
		}
		ss << len;
		ss >> tmp;
		res += tmp;
		res.push_back(s[s.size() - 1]);
		return res;
	}
	string countAndSay(int n) {
		if (n == 1)
			return "1";
		return calculate(countAndSay(n - 1));
	}
};
int main(){
	Solution s;
	cout << s.countAndSay(6);
	system("pause");
	return 0;
}
