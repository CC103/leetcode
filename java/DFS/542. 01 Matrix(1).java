import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return matrix;
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) queue.offer(new Point(i, j));
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = cur.x + dirs[i][0];
                int y = cur.y + dirs[i][1];

                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[cur.x][cur.y] + 1) continue;
                matrix[x][y] = matrix[cur.x][cur.y] + 1;
                queue.add(new Point(x, y));
            }
        }

        return matrix;

    }
}
