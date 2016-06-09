#include<stack>
#include<string>
#include<iostream>
using namespace std;
class Solution {
public:
	bool isValid(string s) {
		stack<char> stack;
		for (int i = 0; i < s.size(); i++){
			if (s[i] == '(' || s[i] == '[' || s[i] == '{'){
				stack.push(s[i]);
				continue;
			}
			else{
				if (stack.empty())
					return false;
			}
			if (s[i] == ')'){
				if (stack.top() == '('){
					stack.pop();
					continue;
				}
				return false;
			}
			if (s[i] == ']'){
				if (stack.top() == '['){
					stack.pop();
					continue;
				}
				return false;
			}
			if (s[i] == '}'){
				if (stack.top() == '{'){
					stack.pop();
					continue;
				}
				return false;
			}
		}
		return stack.empty();
	}
};

int main(){
	string s = "({}{[]})";
	Solution A;
	cout << A.isValid(s);
	system("pause");
	return 0;
}
