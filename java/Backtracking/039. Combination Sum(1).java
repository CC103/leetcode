import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new ArrayList<>(), 0, 0);

        return res;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int sum, int index) {
        if(sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target) return;

        else{
            for(int i = index; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(candidates, target, res, temp, sum + candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
