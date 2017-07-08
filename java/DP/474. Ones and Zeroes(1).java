public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {


        int dp[][] = new int[m + 1][n + 1];

        for (String s : strs) {
            int num0 = 0;
            int num1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') num0++;
                else num1++;
            }

            for (int i = m; i >= num0; i--) {
                for (int j = n; j >= num1; j--) {
                    dp[i][j] = Math.max(dp[i - num0][j - num1] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];

    }
}
