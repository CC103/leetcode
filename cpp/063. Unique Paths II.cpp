class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        if(obstacleGrid.empty())
            return 0;
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        vector<vector<int>> v(m, vector<int>(n, 1));
        //在最右以及最下的一行，一旦出现一个障碍物，则此路不通，意味着该障碍物上游的一条路为死路，全部置为0.
        for(int i = 0; i < n; i++){
            if(obstacleGrid[m - 1][i] == 1){
                for(int j = 0; j <= i; j++)
                    v[m - 1][j] = 0;
                continue;
            }
                
        }
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][n - 1] == 1){
                for(int j = 0; j <= i; j++)
                    v[j][n - 1] = 0;
                continue;
            }
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    v[i][j] = 0;
                    continue;
                }
                v[i][j] = v[i][j + 1] + v[i + 1][j];
            }
        }
        return v[0][0];
        
    }
};
