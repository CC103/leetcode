import java.util.*;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int sol[] = new int[n];
        DFS(res, sol, 0, n);
        return res;

    }

    public void DFS(List<List<String>> res, int[] sol, int row, int n) {
        for (int col = 0; col < n; col++) {
            boolean flag = true;
            for (int j = 0; j < row; j++) {
                if (sol[j] == col || col - sol[j] == row - j || col - sol[j] == j - row) flag = false;
            }
            if (!flag) continue;
            sol[row] = col;
            if (row == n - 1) res.add(generate(sol));
            else DFS(res, sol, row + 1, n);
        }
    }


    public List<String> generate(int[] sol) {
        int n = sol.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                if (j == sol[i]) s += "Q";
                else s += ".";
            }
            res.add(s);
        }
        return res;
    }
}
