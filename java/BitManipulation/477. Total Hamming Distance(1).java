public class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int total = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (((nums[j] >> i) & 1) == 1) count++;
            }

            total += count * (n - count);
        }

        return total;
    }
}
