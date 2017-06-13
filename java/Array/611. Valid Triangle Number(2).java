import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for(int i = nums.length - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while(l < r) {
                if(nums[l] + nums[r] > nums[i]) {
                    // fix r, l could be[l, r-1]
                    count += r - l;
                    r--;
                }
                else l++;
            }
        }
        return count;

    }
}
