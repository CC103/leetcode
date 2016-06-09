#include<iostream>
#include<string>
#include<vector>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	bool wordPattern(string pattern, string str) {
		vector<string> hashTable;
		string s;
		for (int i = 0; i < 26; i++){
			hashTable.push_back(s);
		}
		vector<string> words;
		string word;
		for (int i = 0; i < str.size(); i++){
			if (str[i] == ' '){
				//增添一个指示位
				word.push_back('0');
				words.push_back(word);
				word = "";
				continue;
			}
			word.push_back(str[i]);
		}
		word.push_back('0');
		words.push_back(word);
/*		
		for (int i = 0; i < words.size(); i++){
			cout << words[i] <<endl;
		}
*/
		if (pattern.size() != words.size())
			return false;

		for (int i = 0; i < pattern.size(); i++){
			if (hashTable[pattern[i] - 97].empty() && words[i][words[i].size() - 1] == '0'){
				for (int q = i + 1; q < words.size(); q++){
					if (words[q] == words[i]){
						//字符串的最后一个字母即标志位置为对应pattern的大写
						words[q][words[q].size() - 1] = pattern[i] - 32;
						cout << q << "	" << words[q] << endl;
					}
				}
				words[i][words[i].size() - 1] = pattern[i] - 32;
				hashTable[pattern[i] - 97] = words[i];
				continue;
			}
			if (hashTable[pattern[i] - 97] == words[i])
				continue;
			return false;
		}
		return true;
	}
};
int main(){
	string a = "aaaa";
	string b = "dog dog dog dog";
	Solution s;

	cout <<"bool"<<s.wordPattern(a, b);
	system("pause");
}
