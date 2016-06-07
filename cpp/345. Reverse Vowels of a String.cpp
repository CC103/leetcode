#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
	string reverseVowels(string s) {
		char arr[100000];
		int j = 0;
		for (int i = 0; i < s.size(); i++){
			if (s[i] == 'a' || s[i] == 'e' || s[i] == 'o' || s[i] == 'i' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U'){
				arr[j] = s[i];
				j++;
				s[i] = NULL;
			}
		}
		j--;
		for (int i = 0; i < s.size(); i++){
			if (s[i] == NULL){
				s[i] = arr[j];
				j--;
			}
		}
		return s;
	}
};
