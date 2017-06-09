// Greedy
public class Solution {
    public boolean canJump(int[] nums) {
        int scope = 1;

        for(int i = 0; i < scope && i < nums.length; i++) {
            scope = scope < nums[i] + i + 1 ? nums[i] + i + 1 : scope;
            if(scope >= nums.length) return true;
        }
        return false;

    }
}
