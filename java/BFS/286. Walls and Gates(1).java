import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j, 0});
            }
        }

        int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dirs[i][0];
                int y = cur[1] + dirs[i][1];

                // wall and gate should not be added
                if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] > cur[2] + 1) {
                    // update shortest distance to a gate
                    rooms[x][y] = cur[2] + 1;
                    queue.add(new int[]{x, y, cur[2] + 1});
                }
            }
        }

    }
}
