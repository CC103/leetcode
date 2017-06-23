import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), target, 0, candidates);
        return res;

    }

    public void backtrack(List<List<Integer>> res, List<Integer> temp, int target, int start, int[] candidates) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0) return;

        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i - 1] == candidates[i]) continue;
            temp.add(candidates[i]);
            backtrack(res, temp, target - candidates[i], i + 1, candidates);
            temp.remove(temp.size() - 1);
        }
    }
}
