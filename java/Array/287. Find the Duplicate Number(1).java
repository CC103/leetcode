// Brute violence O(n2)
public class Solution {
    public int findDuplicate(int[] nums) {
        int l, r;
        for(l = 0; l < nums.length; l++) {
            for(r = l + 1; r < nums.length; r++) {
                if(nums[r] == nums[l]) return nums[r];
            }
        }
        return 0;
    }
}
