class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
    	if(grid.empty()) return 0;
    	int m = grid.size(), n = grid[0].size();
    	vector<vector<int>> sum(m, vector<int>(n, 0));
    	sum[0][0] = grid[0][0];
    	for(int i = 1; i < m; i++){
    		sum[i][0] = sum[i - 1][0] + grid[i][0]; 
    	}
    	for(int i = 1; i < n; i++){
    		sum[0][i] = sum[0][i - 1] + grid[0][i]; 
    	}
    	for(int i = 1; i < m; i++){
    		for(int j = 1; j < n; j++){
    			sum[i][j] = grid[i][j] + min(sum[i - 1][j], sum[i] [j - 1]);
    		}
    	}
    	return sum[m - 1][n - 1];

    }
};