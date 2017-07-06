public class Solution {
    public int getMoneyAmount(int n) {
        int memory[][] = new int[n + 1][n + 1];
        return dp(memory, 1, n);


    }

    public int dp(int[][] memory, int start, int end) {
        if(start >= end) return 0;

        if(memory[start][end] != 0) return memory[start][end];

        int res = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++) {
            int n = Math.max(dp(memory, start, i - 1), dp(memory, i + 1, end)) + i;
            res = Math.min(res, n);

        }

        memory[start][end] = res;

        return res;
    }
}
