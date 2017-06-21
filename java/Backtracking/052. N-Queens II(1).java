import java.util.*;

public class Solution {
    public int totalNQueens(int n) {
        int sol[] = new int[n];
        int count[] = new int[1];
        DFS(sol, 0, n, count);
        return count[0];

    }

    public void DFS(int[] sol, int row, int n, int[] count) {
        for (int col = 0; col < n; col++) {
            boolean flag = true;
            for (int j = 0; j < row; j++) {
                if (sol[j] == col || col - sol[j] == row - j || col - sol[j] == j - row) flag = false;
            }
            if (!flag) continue;
            sol[row] = col;
            if (row == n - 1) count[0]++;
            else DFS(sol, row + 1, n, count);
        }
    }
}
