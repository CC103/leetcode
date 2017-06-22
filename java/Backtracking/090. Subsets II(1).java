import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(res, new ArrayList<>(), nums, 0);
        return res;

    }

    public void backtrack(List<List<Integer>> res, List<Integer> temp, int nums[], int start) {
        res.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i - 1] == nums[i]) continue;
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
