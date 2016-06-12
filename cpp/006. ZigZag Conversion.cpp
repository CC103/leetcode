#include<iostream>
#include<string>
#include<vector>
using namespace std;
class Solution {
public:
	string convert(string s, int numRows) {
		if (numRows == 0)
			return "";
		if (numRows == 1)
			return s;
		vector<string> arr(numRows);
		for (int i = 0; i < s.size(); i++){
			int rem = i % (2 * numRows - 2);
			if (rem >= 0 && rem <= (numRows - 1))
				arr[rem].push_back(s[i]);
			else
				arr[2 * numRows - rem - 2].push_back(s[i]);
		}
		string retStr;
		for (int i = 0; i < numRows; i++){
			retStr += arr[i];
		}
		return retStr;
	}
};
