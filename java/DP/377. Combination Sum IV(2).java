public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(target == 0) return 1;
        if(target < 0) return 0;

        int res = 0;
        for(int i: nums) {
            res += combinationSum4(nums, target - i);
        }

        return res;
    }

}
