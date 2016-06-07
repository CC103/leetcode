#include<iostream>
#include<string>
#include<stdlib.h>
using namespace std;
// 使用了HashTable的思想	
class Solution {
public:
	bool isAnagram(string s, string t) {
		if (s.size() != t.size())
			return false;
		int len = s.size();
		int frequency[256] = { 0 };
		for (int i = 0; i < len; i++)
			frequency[s[i]]++;
		for (int i = 0; i < len; i++){
			if (frequency[t[i]] == 0)
				return false;
			frequency[t[i]]--;
		}
		for (int i = 0; i < 26; i++){
			if (frequency[i] != 0)
				return false;
		}
		return true;
	}
};

int main(){
	string s = "aaaaaaa";
	string t = "aaaabbb";
	Solution temp;
	bool result = temp.isAnagram(s, t);
	cout << result;
	system("pause");
	return 0;
}
