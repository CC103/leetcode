public class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        for(int j = 1; j <= p.length(); j++) {
            // x* here counts as empty
            if(p.charAt(j - 1) == '*') {
                if(dp[0][j - 1] || j > 1 && dp[0][j - 2]) dp[0][j] = true;
            }
        }

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < p.length(); j++) {

                // i, j here starts from zero, dp in fact starts from 1
                if(p.charAt(j) == '.') dp[i + 1][j + 1] = dp[i][j];

                if(p.charAt(j) == s.charAt(i)) dp[i + 1][j + 1] = dp[i][j];

                if(p.charAt(j) == '*') {
                    // count as empty
                    if(p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') dp[i + 1][j + 1] = dp[i + 1][j - 1];

                    // empty, single, multiple
                    else dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
                }


            }
        }

        return dp[s.length()][p.length()];


    }
}
