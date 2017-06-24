public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;

        // to make sure health equals 1 when knight arrives here
        dungeon[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        for(int i = m - 2; i >= 0; i--) {
            dungeon[i][n - 1] = Math.max(dungeon[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for(int j = n - 2; j >= 0; j--) {
            dungeon[m - 1][j] = Math.max(dungeon[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                int down = Math.max(dungeon[i - 1][j] - dungeon[i][j], 1);
                int right = Math.max(dungeon[i][j + 1] - dungeon[i][j], 1);
                dungeon[i][j] = Math.min(down, right);
            }
        }

        return dungeon[0][0];
    }
}
