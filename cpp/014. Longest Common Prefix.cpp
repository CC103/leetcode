#include <iostream>
#include<vector>
#include<string>
using namespace std;
class Solution {
public:
	string longestCommonPrefix(vector<string>& strs) {
		string maxPrefix;
		if (strs.empty())
			return maxPrefix;
		maxPrefix = strs[0];
		for (int i = 1; i < strs.size(); i++){
			if (maxPrefix.size() == 0)
				return maxPrefix;
			for (int j = 0; j < maxPrefix.size(); j++){
				if (strs[i].size() <= j || maxPrefix[j] != strs[i][j]){
					maxPrefix.erase(maxPrefix.begin() + j, maxPrefix.end());
					break;
				}
			}
		}
		return maxPrefix;
	}
};
