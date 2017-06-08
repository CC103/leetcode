// Bit manipulation
public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for(; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        // the last index n
        xor ^= i;

        return xor ^ 0;
    }
}
