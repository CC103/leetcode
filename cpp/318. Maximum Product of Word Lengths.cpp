#include<iostream>
#include<string>
#include<vector>
using namespace std;

class Solution {
public:
	int turnWordToBits(string word){
		int ret = 0;
		int words[26] = { 0 };
		for (int i = 0; i < word.size(); i++){
			if (words[word[i] - 'a'] == 0)
				words[word[i] - 'a'] = 1;
		}
		for (int i = 0; i < 26; i++){
			if (words[i] == 1)
				ret += pow(2, i);
		}
		return ret;
	}
	int maxProduct(vector<string>& words) {
		int bits[words.size() + 1];
		int max = 0;
		for (int i = 0; i < words.size(); i++){
			bits[i] = turnWordToBits(words[i]);
		}
		for (int i = 0; i < words.size(); i++){
			for (int j = i + 1; j < words.size(); j++){
				if (int(bits[i] & bits[j]) == 0){
					int pro = words[i].size() * words[j].size();
					if (pro > max)
						max = pro;
				}
			}
		}
		return max;
	}
};
