public class Solution {
    private int len = 0;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int memory[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j, memory);
            }
        }

        return len;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] memory) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (memory[i][j] != 0) return memory[i][j];

        int max = 0;
        // up
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) max = Math.max(max, dfs(matrix, i - 1, j, memory));
        // left
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) max = Math.max(max, dfs(matrix, i, j - 1, memory));
        //down
        if (i + 1 < m && matrix[i + 1][j] > matrix[i][j]) max = Math.max(max, dfs(matrix, i + 1, j, memory));
        // right
        if (j + 1 < n && matrix[i][j + 1] > matrix[i][j]) max = Math.max(max, dfs(matrix, i, j + 1, memory));

        int curLen = max + 1;
        len = Math.max(len, curLen);
        memory[i][j] = curLen;
        return curLen;
    }
}
