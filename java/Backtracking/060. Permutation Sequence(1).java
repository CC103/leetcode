import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", n, k);
        return res.get(k - 1);

    }

    public void backtrack(List<String> res, String temp, int n, int k) {
        if(temp.length() == n) res.add(temp);
        if(res.size() == k) return;

        for(int i = 1; i <= n; i++) {
            String digit = String.valueOf(i);
            if(!temp.contains(digit)) {
                backtrack(res, temp + digit, n, k);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.getPermutation(3,3);
    }
}
