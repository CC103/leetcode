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
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;

        int m = maze.length;
        int n = maze[0].length;
        Queue<Point> queue = new LinkedList<>();

        // memorization
        int visited[][] = new int[m][n];

        // four moving directions
        int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        queue.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = 1;

        // bfs
        while(!queue.isEmpty()) {
            Point cur = queue.poll();

            // traverse four directions
            for (int i = 0; i < 4; i++) {
                int x = cur.x;
                int y = cur.y;

                // won't stop unitl hit a wall
                while (x >=0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[i][0];
                    y += dir[i][1];
                }
                // return to the border
                x -= dir[i][0];
                y -= dir[i][1];

                if (visited[x][y] == 1) continue;
                if (x == destination[0] && y == destination[1]) return true;
                visited[x][y] = 1;

                queue.offer(new Point(x, y));
            }
        }

        return false;

    }
}
