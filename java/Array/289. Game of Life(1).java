public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int p = Math.max(0, i - 1); p < Math.min(m, i + 2); p++){
                    for (int q = Math.max(0, j - 1); q < Math.min(n, j + 2); q++) {
                        count += board[p][q] & 1;
                    }
                }

                // board[i][j] 的下一轮还没算，所以只可能是01或者00
                if (count == 3 || count - board[i][j] == 3) {
                    board[i][j] |= 2;
                }

            }
        }

        // Update the whole graph
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
