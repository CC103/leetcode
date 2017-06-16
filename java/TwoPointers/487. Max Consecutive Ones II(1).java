public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int zeroIndex = -1;
        int l = 0, r = 0;

        while(r < nums.length) {
            if(nums[r] == 1) r++;
            else {
                max = Math.max(r - l, max);
                l = zeroIndex + 1;
                zeroIndex = r;
                r++;
            }
        }

        max = Math.max(r - l, max);
        return max;

    }
}
