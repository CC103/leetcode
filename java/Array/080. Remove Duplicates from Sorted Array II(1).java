public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0, r = 1, count = 1;
        for(; r < nums.length; r++) {
            if(nums[r] != nums[l]) {
                l++;
                count++;
                nums[l] = nums[r];
            }
            else {
                if(l == 0 || nums[r] != nums[l - 1]) {
                    l++;
                    count++;
                    nums[l] = nums[r];
                }
            }
        }
        return count;
    }
}
