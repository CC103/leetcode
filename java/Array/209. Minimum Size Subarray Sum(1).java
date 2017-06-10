// two pointers
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0, r = 0;
        int sum = nums[0], count = 1, min = Integer.MAX_VALUE;

        while(r < nums.length) {
            if(sum >= s) {
                min = min < (r - l + 1) ? min : (r - l + 1);
                sum -= nums[l];
                l++;
            }
            else {
                r++;
                if(r < nums.length) sum += nums[r];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
