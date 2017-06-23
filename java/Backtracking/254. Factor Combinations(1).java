import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, 2, n);
        return res;

    }

    public void backtrack(List<List<Integer>> res, List<Integer> temp, int n, int start, int origin) {
        if(n == 1 && origin != 1) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i <= n; i++) {
            if(n % i == 0 && i != origin) {
                temp.add(i);
                backtrack(res, temp, n / i, i, origin);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.getFactors(6);
    }
}
