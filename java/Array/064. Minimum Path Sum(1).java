// DP
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int j = n - 2; j >= 0; j--) {
            grid[m - 1][j] += grid[m - 1][j + 1];
        }

        for(int j = m - 2; j >= 0; j--) {
            grid[j][n - 1] += grid[j + 1][n - 1];
        }


        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];

    }
}
