public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int len = nums.length;
        int flag = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) len--;

            else if (nums[i] > nums[i - 1]) {
                if (flag == 1) len--;
                else flag = 1;
            } else if (nums[i] < nums[i - 1]) {
                if (flag == -1) len--;
                else flag = -1;
            }
        }

        return len;

    }
}
