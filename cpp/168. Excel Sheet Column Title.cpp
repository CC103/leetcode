#include<iostream>
#include<string>
using namespace std;
class Solution {
public:
    string convertToTitle(int n) {
        string result;
        while(n > 0){
            char c = 'A' + (n-1)% 26;
            result.insert(result.begin(), c);
            n = (n-1)/26;
        }
        return result;
    }
};
