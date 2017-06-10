// binary search
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        int f[] = {-1, -1};

        if(nums == null || nums.length == 0) return f;

        res[0] = findLow(nums, target);
        if(nums[res[0]] != target) return f;

        res[1] = findHigh(nums, target);
        if(nums[res[1]] != target) return f;

        return res;

    }

    public int findLow(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;

        while(l < r) {
            m = (l + r) / 2;
            if(nums[m] >= target)  r = m;
            else l = m + 1;
        }

        return r;

    }

    public int findHigh(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;

        while(l < r) {
            // Make mid biased to the right
            m = (l + r) / 2 + 1;
            if(nums[m] > target) r = m - 1;
            else l = m;
        }

        return r;
    }
}
