// TLE
public class Solution {
    public int rob(int[] nums) {
        int m = nums.length;
        if(m == 0) return 0;
        if(m == 1) return nums[0];
        if(m == 2) return Math.max(nums[0], nums[1]);

        int memory[][] = new int[m][m];

        return Math.max(helper(nums, memory, 1, m - 1), nums[0] + helper(nums, memory, 2, m - 2));
    }

    public int helper(int[] nums, int[][] memory, int start, int end) {
        if(start > end) return 0;

        if(memory[start][end] != 0) return memory[start][end];

        if(start == end || end == start + 1) {
            int profit = Math.max(nums[start], nums[end]);
            memory[start][end] = profit;
            return profit;
        }

        int profit = Math.max(helper(nums, memory, start + 1, end), nums[start] + helper(nums, memory, start + 2, end));
        memory[start][end] = profit;

        return profit;
    }
}
