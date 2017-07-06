// TLE
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int res[] = new int[1];
        helper(res, new ArrayList<>(), target, nums);
        return res[0];
    }

    public void helper(int[] res, List<Integer> temp, int target, int[] nums) {
        if (target < 0) return;
        if (target == 0) {
            res[0]++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            temp.add(cur);
            helper(res, temp, target - cur, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
