public class Solution {
    public int rob(int[] nums) {
        int m = nums.length;
        if (m == 0) return 0;
        if (m == 1) return nums[0];

        return Math.max(helper(nums, 0, m - 2), helper(nums, 1, m - 1));
    }

    public int helper(int[] nums, int start, int end) {
        int pre = 0, cur = 0;

        while (start <= end) {
            int temp = cur;
            cur = Math.max(pre + nums[start], temp);
            pre = temp;

            start++;
        }

        return cur;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.rob(new int[]{1, 2, 3});
    }
}
