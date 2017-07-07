public class Solution {
    public int minCostII(int[][] costs) {
        int m = costs.length;
        if (m == 0) return 0;

        int n = costs[0].length;
        if (n == 0) return 0;

        for (int i = 1; i < m; i++) {

            for(int k = 0; k < n; k++) {

                int min = Integer.MAX_VALUE;

                for (int j = 0; j < n; j++) {
                    // update sum cost
                    if(j == k) continue;
                    min = Math.min(min, costs[i - 1][j]);
                }

                costs[i][k] += min;
            }
        }

        int res = Integer.MAX_VALUE;

        for(int cost: costs[m - 1]) {
            res = Math.min(res, cost);
        }

        return res;

    }
}
