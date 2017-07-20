import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;

        int dis[][] = new int[m][n];
        int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int reachBuildings[][] = new int[m][n];
        int numOfBuilding = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numOfBuilding++;
                    Queue<int[]> queue = new LinkedList<>();
                    boolean isVisited[][] = new boolean[m][n];

                    isVisited[i][j] = true;
                    queue.add(new int[]{i, j, 0});

                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        int x = point[0];
                        int y = point[1];
                        int d = point[2];

                        // add distance
                        dis[x][y] += d;
                        reachBuildings[x][y]++;

                        for (int p = 0; p < 4; p++) {
                            int xx = x + dirs[p][0];
                            int yy = y + dirs[p][1];
                            if (xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] == 0 && !isVisited[xx][yy]) {
                                isVisited[xx][yy] = true;
                                queue.add(new int[]{xx, yy, d + 1});
                            }
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // building block maybe meet reachBuildings
                if (grid[i][j] == 0 && reachBuildings[i][j] == numOfBuilding) min = Math.min(min, dis[i][j]);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;

    }
}
