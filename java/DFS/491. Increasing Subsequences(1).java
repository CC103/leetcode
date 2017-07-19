import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(set, new ArrayList<>(), nums, 0);
        List<List<Integer>> res = new ArrayList<>(set);

        return res;

    }

    public void backtrack(Set<List<Integer>> set, List<Integer> temp, int[] nums, int start) {
        if (temp.size() >= 2) set.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) <= nums[i]) {
                temp.add(nums[i]);
                backtrack(set, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
