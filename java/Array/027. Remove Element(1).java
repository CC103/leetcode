public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int l = 0, r = 0;
        for(; r < nums.length; r++) {
            if(nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
            else length--;
        }
        return length;
    }
}
