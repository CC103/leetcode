// DP
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, cur = 0;

        for(int i: nums) {
            if(cur <= 0) cur = i;
            else cur += i;

            max = cur > max ? cur : max;
        }

        return max;
    }
}
