import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // four sides
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') queue.add(new int[]{i, j});
                }
            }
        }

        int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int x = cur[0];
            int y = cur[1];
            board[x][y] = '1';

            for (int i = 0; i < 4; i++) {
                int xx = x + dirs[i][0];
                int yy = y + dirs[i][1];

                if (xx >= 0 && xx < m && yy >= 0 && yy < n && board[xx][yy] == 'O') queue.add(new int[]{xx, yy});
            }
        }

        // change surrounded regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }

    }


}
