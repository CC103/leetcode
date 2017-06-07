// Extra space

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        int res[][] = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[j][m - i - 1] = matrix[i][j];
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }
}
