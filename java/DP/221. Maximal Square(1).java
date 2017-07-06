public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int size[][] = new int[m][n];
        int max = 0;

        for(int i = 0; i < m; i++) {
            size[i][0] = matrix[i][0] - '0';
            if(size[i][0] == 1) max = 1;
        }

        for(int j = 0; j < n; j++) {
            size[0][j] = matrix[0][j] - '0';
            if(size[0][j] == 1) max = 1;
        }


        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '0') size[i][j] = 0;

                else {
                    size[i][j] = Math.min(size[i - 1][j], Math.min(size[i][j - 1], size[i - 1][j - 1])) + 1;
                    max = Math.max(max, size[i][j]);
                }
            }
        }

        return max * max;

    }
}
