public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int l = 0, r = nums.length - 1;
        int m;

        while(l <= r) {
            m = (l + r) / 2;
            if(nums[m] == target) return m;

            if(nums[m] > target) {
                if(nums[m] > nums[nums.length - 1] && target <= nums[nums.length - 1]) l = m + 1;
                else r = m - 1;
            }
            else {
                if(nums[m] < nums[0] && target > nums[nums.length - 1]) r = m - 1;
                else l = m + 1;
            }
        }

        return -1;

    }
}
