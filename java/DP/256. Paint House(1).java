public class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        if(m == 0) return 0;

        for(int i = 1; i < m; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
        }

        return Math.min(Math.min(costs[m - 1][1], costs[m - 1][2]), costs[m - 1][0]);

    }
}
