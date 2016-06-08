#include<iostream>
#include<string>
#include<sstream>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	string getHint(string secret, string guess) {
		int bulls = 0;
		int cows = 0;
		int cowsHash[10] = { 0 };
		int size = secret.size();
		for (int i = 0; i < size; i++){
			if (secret[i] == guess[i]){
				bulls++;
				secret[i] = NULL;
				guess[i] = NULL;
			}
		}

		for (int i = 0; i < size; i++){
			if (guess[i] != NULL){
				cowsHash[guess[i] - 48] += 1;
			}
		}
		for (int i = 0; i < size; i++){
			if (secret[i] != NULL){
				if (cowsHash[secret[i] - 48] > 0){
					cowsHash[secret[i] - 48] --;
					cows++;
				}
			}
		}
		string res = "";
		string tmp;
		stringstream s1;
		s1 << bulls;
		s1 >> tmp;
		res += tmp;
		tmp = "";
		res.push_back('A');
		stringstream s2;
		s2 << cows;
		s2 >> tmp;
		res += tmp;
		res.push_back('B');
		return res;
	}
};
