#include <stdlib.h>
#include <iostream>
#include <vector>
#include <string>
using namespace std;
// NOT WORK YET
class Solution {
public:
    vector<int> diffWaysToCompute(string input) {
     	 vector<string> vecOp;
     	 vector<int> ret;
     	 string tmp = "";
     	 for(int i = 0; i < input.size(); i++){
     	 	if(input[i] == '+' || input[i] == '-' || input[i] == '*'){
     	 		if(!tmp.empty()){
     	 			vecOp.push_back(tmp);
     	 			tmp = "";
     	 		}
     	 		string s;
     	 		s.push_back(input[i]);
     	 		vecOp.push_back(s);
     	 	}
     	 	else{
     	 		tmp += input[i];
     	 	}
     	 }
     	 if(!tmp.empty()){
     	 	vecOp.push_back(tmp);
     	 }
     	 //test the division
     	 // for(int i = 0; i < vecOp.size(); i++){
     	 // 	cout << vecOp[i] << "||";
     	 // }
     	 recurCal(vecOp, ret);
     	 return ret;
    }
    void recurCal(vector<string> vecOp, vector<int> &ret){
    	int size = vecOp.size();
    	if(size == 0)
    		return;
    	if(size == 1){
    		int tmp = atoi(vecOp[0].c_str());
    		ret.push_back(tmp);
    		return;
    	}
    	if(size == 2){
    		if(vecOp[0] == "+"){
    			int tmp = atoi(vecOp[1].c_str());
    			ret.push_back(tmp);
    			return;
    		}
    		if(vecOp[0] == "-"){
    			int tmp = (-1) * atoi(vecOp[0].c_str());
    			ret.push_back(tmp);
    			return;
    		}
    		return;
    	}
    	if(size == 3){
    		if(vecOp[1] == "+"){
    			int tmp = atoi(vecOp[0].c_str()) + atoi(vecOp[2].c_str());
    			ret.push_back(tmp);
    		}
    		if(vecOp[1] == "-"){
    			int tmp = atoi(vecOp[0].c_str()) - atoi(vecOp[2].c_str());
    			ret.push_back(tmp);
    		}
    		if(vecOp[1] == "*"){
    			int tmp = atoi(vecOp[0].c_str()) * atoi(vecOp[2].c_str());
    			ret.push_back(tmp);
    		}
    		return;
    	}
    	//Find all possible position to add parentheses
    	for(int i = 0; i < size; i++){
    		if(i % 2 == 1){
    			vector<string> vtmp = vecOp;
    			int tmp;
    			string stmp;
    			if(vecOp[i] == "+"){
    				tmp = atoi(vecOp[i - 1].c_str()) + atoi(vecOp[i + 1].c_str());
    			}
    			if(vecOp[i] == "-"){
    				tmp = atoi(vecOp[i - 1].c_str()) - atoi(vecOp[i + 1].c_str());
    			}
    			if(vecOp[i] == "*"){
    				tmp = atoi(vecOp[i - 1].c_str()) * atoi(vecOp[i + 1].c_str());
    			}
    			stringstream ss;
    			ss << tmp;
    			ss >> stmp;
    			vtmp.erase(vtmp.begin() + i - 1);
    			vtmp.erase(vtmp.begin() + i + 1);
    			vtmp[i] = stmp;
    			recurCal(vtmp, ret);
    		}
    	}
    }
};
