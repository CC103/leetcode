// Binary search

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int l = 0, r = nums.length - 1, mid;

        while(l < r) {
            mid = l + (r - l) / 2;
            if(nums[mid] < nums[r]) r = mid;
            else if(nums[mid] > nums[r]) l = mid + 1;
            else r--;
        }

        return nums[l];

    }
}
