// In space
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;

        // Reverse up to down
        for(int i = 0; i < m / 2; i++) {
            for(int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - i - 1][j];
                matrix[m - i - 1][j] = temp;
            }
        }

        // Swap the symmetry
        for(int i = 0; i < m; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
