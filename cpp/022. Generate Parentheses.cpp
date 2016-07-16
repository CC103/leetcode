#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> v;
        string str = "";
        s(v, str, n, 0);
        return v;
    }
    void s(vector<string> &v, string str, int n, int m){
        if(n == 0 && m == 0){
            v.push_back(str);
            return;
        }
        if(n > 0)
            s(v, str + "(", n - 1, m + 1);
        if(m > 0)
            s(v, str + ")", n, m - 1);
    }
};
