class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
    	int m = matrix.size();
    	int n = matrix[0].size();
    	vector<vector<int>> newMatrix;
    	for(int i = 0; i < n; i++){
    		vector<int> v;
    		for(int j = m - 1; j >= 0; j--){
    			v.push_back(matrix[j][i]);
    		}
    		newMatrix.push_back(v);
    	}
        matrix = newMatrix;
    }
};
