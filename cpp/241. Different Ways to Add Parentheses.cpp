#include <stdlib.h>
#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    vector<int> diffWaysToCompute(string input) {
    	vector<int> ret;
    	int size = input.size();
    	for(int i = 0; i < size; i++){
    		char c = input[i];
    		if(c == '+' || c == '-' || c == '*'){
    			//Split the input into two parts and solve then recursively
    			vector<int> ret1 = diffWaysToCompute(input.substr(0, i));
    			vector<int> ret2 = diffWaysToCompute(input.substr(i + 1));
    			for(auto item1 : ret1){
    				for(auto item2 : ret2){
    					if(c == '+')
    						ret.push_back(item1 + item2);
    					if(c == '-')
    						ret.push_back(item1 - item2);
    					if(c == '*')
    						ret.push_back(item1 * item2);
    				}
    			}
    		}
    	}
    	//If the input is a number without operators, turn it to Int and push back
    	if(ret.empty()){
    		ret.push_back(atoi(input.c_str()));
    	}
    	//Sort the vector 
    	sort(ret.begin(), ret.end());
    	return ret;
  
    }
};
