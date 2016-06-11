#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
	int strStr(string haystack, string needle) {
		int cur = 0;
		if (needle.size() == 0)
			return 0;
		if (haystack.size() < needle.size())
			return -1;
		for (int i = 0; i < haystack.size();){
			if (haystack[i] != needle[cur]){
				if (cur == 0){
					i++;
					continue;
				}
				i = i - cur + 1;
				cur = 0;
				continue;

			}
			cur++;
			i++;
			if (cur == needle.size())
				return i - cur;
		}
		return -1;
	}
};
