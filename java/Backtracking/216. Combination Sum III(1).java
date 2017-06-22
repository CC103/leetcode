import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;

    }

    public void backtrack(List<List<Integer>> res, List<Integer> temp, int target, int k, int start) {
        if(target == 0 && temp.size() == k) res.add(new ArrayList<>(temp));
        if(target < 0 || temp.size() >= k) return;

        for(int i = start; i <= 9; i++) {
            temp.add(i);
            backtrack(res, temp, target - i, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
