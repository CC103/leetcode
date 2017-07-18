import java.util.*;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(res, s, 0, 0, new char[]{'(', ')'});

        return res;
    }

    public void remove(List<String> res, String s, int last_i, int last_j, char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;

            if (stack >= 0) continue;

            // remove invalid parentheses
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(res, s.substring(0, j) + s.substring(j + 1, s.length()), i, j, par);
                }
            }

            // to avoid duplicate
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();

        // finish from left to right, remove )
        if (par[0] == '(') remove(res, reversed, 0, 0, new char[]{')', '('});
        // finish from right to left
        else res.add(reversed);
    }

}
