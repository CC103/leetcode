#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<int> grayCode(int n) {
    	vector<int> res{0};
        for(int i = 1; i <= n; i++){
        	int sum = pow(2, i - 1);
        	int size = res.size();
        	for(int i = size - 1; i >= 0; i--){
        		int tmp = res[i] + sum;
        		res.push_back(tmp);
        	}
        }
        return res;
    }
};
