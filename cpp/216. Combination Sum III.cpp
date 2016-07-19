#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> res;
        vector<int> sol;
        recursiveCal(res, sol, k, n);
        return res;
    }
    void recursiveCal(vector<vector<int>> &res, vector<int> &sol, int k, int n){
    	if(sol.size() == k && n == 0){
    		res.push_back(sol);
    		return;
    	}
    	if(sol.size() < k){
    	for(int i = sol.empty()? 1 : sol.back() + 1; i < 10; i++){
    		if(i > n)
    			break;
    		//try each possible value here 
    		sol.push_back(i);
    		recursiveCal(res, sol, k, n - i);
    		sol.pop_back();
    	}
    	}

    }
};
