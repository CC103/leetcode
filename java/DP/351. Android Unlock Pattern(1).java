public class Solution {
    public int numberOfPatterns(int m, int n) {
        if (m > n || m <= 0) return 0;

        boolean isVisited[] = new boolean[10];

        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[3][9] = skip[9][3] = 6;
        skip[9][7] = skip[7][9] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;

        int res = 0;
        for (int i = m; i <= n; i++) {
            res += DFS(isVisited, skip, 1, i) * 4;
            res += DFS(isVisited, skip, 2, i) * 4;
            res += DFS(isVisited, skip, 5, i);
        }

        return res;

    }

    public int DFS(boolean[] isVisited, int[][] skip, int cur, int remaining) {
        if (remaining == 0) return 1;

        isVisited[cur] = true;

        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (!isVisited[i] && (skip[cur][i] == 0 || isVisited[skip[cur][i]])) {
                res += DFS(isVisited, skip, i, remaining - 1);
            }
        }

        // Reset
        isVisited[cur] = false;

        return res;
    }
}
