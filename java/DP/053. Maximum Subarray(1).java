public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int cur = nums[0], max = cur;

        for(int i = 1; i < nums.length; i++) {
            if(cur > 0) {
                cur += nums[i];
            }
            else cur = nums[i];

            max = Math.max(max, cur);
        }

        return max;
    }
}
