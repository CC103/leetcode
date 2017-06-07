// Swap
public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int l = 0, r = length - 1;
        for(; l <= r;) {
            if(nums[l] == val) {
                nums[l] = nums[r];
                r--;
                length--;
            }
            else l++;
        }
        return length;
    }
}
