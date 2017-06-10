public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1, m;
        while(l < r) {
            m = (l + r) / 2;
            if(nums[m] == target) return m;
            else if(nums[m] < target) l = m + 1;
            else r = m;
        }

        if(nums[l] >= target) return l;
        else return l + 1;
    }
}
