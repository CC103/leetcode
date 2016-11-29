class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if(grid.empty()) return 0;
        return dp(grid, 0, 0);
    }
    int dp(vector<vector<int>>& grid, int m, int n){
    	if(m == grid.size() - 1){
    		int sum = 0;
    		for(; n < grid[0].size(); n++){
    			sum += grid[m][n];
    		}
    		return sum;
    	}
    	else if(n == grid[0].size() - 1){
    		int sum = 0;
    		for(; m < grid.size(); m++){
    			sum += grid[m][n];
    		}
    		return sum;
    	}
    	else{
    		return min(dp(grid, m + 1, n), dp(grid, m, n + 1)) + grid[m][n];
    	}		
    }
};