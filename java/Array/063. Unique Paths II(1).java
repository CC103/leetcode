// DP
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        for(int i = m - 1; i >= 0; i--) {
            if(obstacleGrid[i][n - 1] == 1) {
                for(; i >= 0; i--) {
                    // Avoid influence bottom line
                    if(i != m - 1) obstacleGrid[i][n - 1] = 0;
                }
            }
            else {
                // Avoid influence bottom line
                if(i != m - 1) obstacleGrid[i][n - 1] = 1;
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            if(obstacleGrid[m - 1][i] == 1) {
                for(; i >= 0; i--) {
                    obstacleGrid[m - 1][i] = 0;
                }
            }
            else obstacleGrid[m - 1][i] = 1;
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else obstacleGrid[i][j] = obstacleGrid[i + 1][j] + obstacleGrid[i][j + 1];
            }
        }

        return obstacleGrid[0][0];
    }
}
