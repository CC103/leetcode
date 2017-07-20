import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];

        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            // pacific border
            pQueue.add(new int[]{i, 0});
            pacific[i][0] = true;
            // atlantic border
            aQueue.add(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            // pacific border
            pQueue.add(new int[]{0, j});
            pacific[0][j] = true;
            // atlantic border
            aQueue.add(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }

        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlantic[i][j] && pacific[i][j])
                    res.add(new int[]{i, j});
            }
        }

        return res;
    }

    public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] isVisited) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int xx = x + dirs[i][0];
                int yy = y + dirs[i][1];

                if (xx < 0 || xx >= m || yy < 0 || yy >= n || isVisited[xx][yy] || matrix[xx][yy] < matrix[x][y]) continue;
                isVisited[xx][yy] = true;
                queue.add(new int[]{xx, yy});
            }
        }
    }

}
