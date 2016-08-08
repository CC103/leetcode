class Solution {
public:
    vector<string> letterCombinations(string digits) {
    	vector<string> res;
    	if(digits.empty())
    		return res;
    	string map[10] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	res.push_back("");
    	for(int i = 0; i < digits.size(); i++){
    		string s = map[digits[i] - '0'];
    		vector<string> newRes;
    		for(int j = 0; j < s.size(); j++)
    			for(int z = 0; z < res.size(); z++)
    				newRes.push_back(res[z] + s[j]);	
    		res = newRes;
    	}
    	return res;
    }
};
