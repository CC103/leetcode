//leetcode 344. Reverse String
//2016/4/29
#include <iostream>
#include <string>
using namespace std;
int main(){
	string s;
	cin >> s;
	char temp;
	for (int i = 0; i < s.length() / 2; i++){
		temp = s[i];
		s[i] = s[s.length() - 1 - i];
		s[s.length() - 1 - i] = temp;
	}
	cout << s;
	int pause;
	cin >> pause;
	return 0;
}
