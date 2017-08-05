public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, 0, S);
    }

    public int helper(int[] nums, int start, int target) {
        if (target == 0 && start == nums.length) {
            return 1;
        }
        if (start >= nums.length) return 0;

        // positive
        int pos =  helper(nums, start + 1, target - nums[start]);
        // negative
        int neg = helper(nums, start + 1, target + nums[start]);

        return pos + neg;
    }
}
