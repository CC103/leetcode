// Constant space
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return new int[0];

        int res[] = new int[nums.length];
        res[0] = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= temp;
            temp *= nums[j];
        }

        return res;
    }
}
