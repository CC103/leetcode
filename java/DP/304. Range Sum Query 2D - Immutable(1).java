public class NumMatrix {

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) {
            this.matrix = new int[m][0];
            return;
        }
        int n = matrix[0].length;

        this.matrix = new int[m][n];

        for (int row = 0; row < m; row++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[row][i];
                this.matrix[row][i] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 >= matrix.length || row2 >= matrix.length || col1 >= matrix[0].length || col2 >= matrix[0].length)
            return 0;

        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            if(col1 == 0) sum += matrix[i][col2];
            else sum += matrix[i][col2] - matrix[i][col1 - 1];
        }

        return sum;
    }

    private int matrix[][];
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
