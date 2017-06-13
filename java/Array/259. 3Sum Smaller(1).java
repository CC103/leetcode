// Two pointers
import java.util.Arrays;

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {

            int targetSum = target - nums[i];
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = nums[l] + nums[r];
                if(sum < targetSum) {
                    // Must smaller
                    count += r - l;
                    l++;

                }
                else r--;
            }
        }

        return count;

    }
}
