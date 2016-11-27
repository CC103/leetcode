class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ret;
        if(numRows == 0) return ret;
        vector<int> top(1, 1);
        ret.push_back(top);
        for(int i = 2; i <= numRows; i++){
        	vector<int> row(i);
        	row[0] = 1;
        	for(int j = 1; j < i - 1; j++){
        		row[j] = ret[i - 2][j - 1] + ret[i - 2][j]; 
        	}
        	row[i - 1] = 1;
        	ret.push_back(row);
        }
        return ret;
    }
};