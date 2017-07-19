import java.util.*;

public class Solution {
    class Point {
        int x;
        int y;
        int dis;
        public Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return -1;

        int m = maze.length;
        int n = maze[0].length;

        Queue<Point> queue = new PriorityQueue<>((a, b) -> (a.dis - b.dis));

        // memorization
        int len[][] = new int[m][n];
        for (int i = 0; i < len.length; i++) {
            Arrays.fill(len[i], Integer.MAX_VALUE);
        }

        // four moving directions
        int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        queue.offer(new Point(start[0], start[1], 0));

        // bfs
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            // already fount a shorter one
            if (len[cur.x][cur.y] <= cur.dis) continue;

            len[cur.x][cur.y] = cur.dis;
            // traverse four directions
            for (int i = 0; i < 4; i++) {
                int x = cur.x;
                int y = cur.y;
                int dis = cur.dis;

                while (x >=0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[i][0];
                    y += dir[i][1];
                    dis++;
                }
                // return to the border
                x -= dir[i][0];
                y -= dir[i][1];
                dis--;

                queue.offer(new Point(x, y, dis));
            }
        }

        if (len[destination[0]][destination[1]] == Integer.MAX_VALUE) return -1;
        return len[destination[0]][destination[1]];


    }
}
