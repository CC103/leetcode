public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;

        int col0 = 1;

        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) col0 = 0;
            // must start from 1
            // 如果j从0开始，j等于0时的值恰好为0，那么matrix[0][0]会被设置为0，但实际上这是row0而不是col0的标志位
            // 因为col0特殊，所以要对第一列单独处理
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j > 0; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            // Must after the loop, otherwise will disturb the result
            if(col0 == 0) matrix[i][0] = 0;
        }
    }
}
